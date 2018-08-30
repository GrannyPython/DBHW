package quoters;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

/**
 * @author Evgeny Borisov
 */

@Component
public class TransactionAnnotationBeanPostProcessor implements BeanPostProcessor {
    @Autowired
    private ConfigurableListableBeanFactory factory;

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = factory.getType(beanName);
        if (beanClass.isAnnotationPresent(Transaction.class)) {
            return Proxy.newProxyInstance(beanClass.getClassLoader(),beanClass.getInterfaces(), (proxy, method, args) -> {
                System.out.println("************TRANSACTION OPENED**********");
                Object retval = method.invoke(bean, args);
                System.out.println("************TRANSACTION CLOSED **********");
                return retval;

            });
        }
        return bean;
    }
}







