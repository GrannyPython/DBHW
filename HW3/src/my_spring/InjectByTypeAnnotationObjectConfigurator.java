package my_spring;

import java.lang.reflect.Field;

/**
 * @author Evgeny Borisov
 */
public class InjectByTypeAnnotationObjectConfigurator implements ObjectConfigurator {
    @Override
    public void configure(Object t) throws Exception {
        Field[] fields = t.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectByType.class)) {
                Object object = ObjectFactory.getInstance().createObject(field.getType());
                field.setAccessible(true);
                field.set(t, object);
            }
        }
    }
}
