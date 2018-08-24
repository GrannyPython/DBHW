package my_spring;

import heroes.RandomFactory;
import org.reflections.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Set;

/**
 * @author Evgeny Borisov
 */
public class InjectRandomIntAnnotationObjectConfigurator implements ObjectConfigurator {
    @Override
    public void configure(Object t) throws Exception {
        Class<?> type = t.getClass();
        Set<Field> fields = ReflectionUtils.getAllFields(type);
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectRandomInt.class)) {
                InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
                int min = annotation.min();
                int max = annotation.max();
                int value = RandomFactory.getInstance().getNumberBetween(min, max);
                field.setAccessible(true);
                field.set(t, value);
            }
        }
    }
}
