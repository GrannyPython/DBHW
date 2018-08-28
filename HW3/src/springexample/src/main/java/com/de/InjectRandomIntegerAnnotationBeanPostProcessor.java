package springexample.src.main.java.com.de;

import lombok.SneakyThrows;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Field;

public class InjectRandomIntegerAnnotationBeanPostProcessor implements BeanPostProcessor {
    static DataFactory dataFactory = new DataFactory();


    @SneakyThrows
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        Field[] fields = o.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectRandomInt.class)) {
                InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
                int max = annotation.max();
                int min = annotation.min();
                field.setAccessible(true);

                field.set(o, dataFactory.getNumberBetween(min, max));
            }
        }


        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        return o;
    }

}
