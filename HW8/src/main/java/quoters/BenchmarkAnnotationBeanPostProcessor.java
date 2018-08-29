package quoters;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Evgeny Borisov
 */

@Component
public class BenchmarkAnnotationBeanPostProcessor implements BeanPostProcessor {
    private Map<String, Class> map = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> type = bean.getClass();
        if (type.isAnnotationPresent(Benchmark.class)) {
            map.put(beanName, type);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class beanClass = map.get(beanName);
        if (beanClass != null) {
            return Proxy.newProxyInstance(beanClass.getClassLoader(),beanClass.getInterfaces(), (proxy, method, args) -> {
                System.out.println("************BENCHMARK**********");
                Object retval = method.invoke(bean, args);
                System.out.println("************BENCHMARK**********");
                return retval;

            });
        }
        return bean;
    }
}







