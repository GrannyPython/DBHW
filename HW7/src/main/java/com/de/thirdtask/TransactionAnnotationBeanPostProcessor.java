package com.de.thirdtask;

import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.stream.Stream;

public class TransactionAnnotationBeanPostProcessor implements BeanPostProcessor {
    @Override
    @SneakyThrows
    public Object postProcessAfterInitialization(Object t, String beanName) throws BeansException {
        Class typeEfFinal = t.getClass();

        Class type;
        if(typeEfFinal.toString().contains("Proxy")){
            String className = (t.toString().split("@"))[0];
            type = Class.forName(className);
        }else {
            type = typeEfFinal;
        }



        boolean methodNeedsBenchmark = Stream.of(type.getDeclaredMethods()).anyMatch(method -> method.isAnnotationPresent(Transaction.class));
        if (type.isAnnotationPresent(Transaction.class)||methodNeedsBenchmark) {
            if (type.getInterfaces().length == 0) {
                return Enhancer.create(type, (org.springframework.cglib.proxy.InvocationHandler) (o, method, args) -> invoke(t, typeEfFinal, method, args));
            }
            else {
                return Proxy.newProxyInstance(type.getClassLoader(), type.getInterfaces(), (proxy, method, args) -> invoke(t, type, method, args));
            }

        }
        return t;
    }


    private Object invoke(Object t, Class type, Method method, Object[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method classMethod = type.getMethod(method.getName(), method.getParameterTypes());
        if (classMethod.isAnnotationPresent(Transaction.class) || type.isAnnotationPresent(Transaction.class)) {
            System.out.println("********** Transaction for method " + method.getName() + " was started ***********");
            Object retVal = method.invoke(t, args);
            System.out.println("********** Transaction for method " + method.getName() + " was ended ***********");
            return retVal;
        } else {
            return method.invoke(t, args);
        }
    }
}
