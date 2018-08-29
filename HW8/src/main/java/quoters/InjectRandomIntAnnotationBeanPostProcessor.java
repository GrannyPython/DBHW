package quoters;

import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Random;

/**
 * @author Evgeny Borisov
 */

@Component
public class InjectRandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {
    private Random random = new Random();

    @Override
    @SneakyThrows
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> type = bean.getClass();
        Field[] declaredFields = type.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(InjectRandomInt.class)) {
                InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
                int min = annotation.min();
                int max = annotation.max();
                int value = min + random.nextInt(max - min) + 1;
                field.setAccessible(true);
                field.set(bean, value);
            }
        }
        return bean;
    }


}
