package com.de.thirdtask;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.stream.Stream;

public class BenchmarkAnnotationBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object t, String beanName) throws BeansException {
        Class type = t.getClass();
        boolean methodNeedsBenchmark = Stream.of(type.getDeclaredMethods()).anyMatch(method -> method.isAnnotationPresent(Benchmark.class));
        if (type.isAnnotationPresent(Benchmark.class)||methodNeedsBenchmark) {
            if (type.getInterfaces().length == 0) {
                return Enhancer.create(type, (org.springframework.cglib.proxy.InvocationHandler) (o, method, args) -> invoke(t, type, method, args));
            }
            else {
                Object o = Proxy.newProxyInstance(type.getClassLoader(), type.getInterfaces(), (proxy, method, args) -> invoke(t, type, method, args));
                return o;
            }

        }
        return t;
    }


    private Object invoke(Object t, Class type, Method method, Object[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method classMethod = type.getMethod(method.getName(), method.getParameterTypes());
        if (classMethod.isAnnotationPresent(Benchmark.class) || type.isAnnotationPresent(Benchmark.class)) {
            System.out.println("********** benchmark for method " + method.getName() + " was started ***********");
            long start = System.nanoTime();
            Object retVal = method.invoke(t, args);
            long end = System.nanoTime();
            System.out.println(end - start);
            System.out.println("********** benchmark for method " + method.getName() + " was ended ***********");
            return retVal;
        } else {
            return method.invoke(t, args);
        }
    }


}
