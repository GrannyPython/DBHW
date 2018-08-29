package com.de.secondtask;

import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Field;
import java.util.LinkedList;

public class InjectSellerAnnotationBeanPostProcessor implements BeanPostProcessor {
    private LinkedList<Seller> sellers;

    private InjectSellerAnnotationBeanPostProcessor() {
        this.sellers = (LinkedList<Seller>) Database.findAllSellersFromBestToWorse();
    }

    @SneakyThrows
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] declaredFields = bean.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if ((declaredField.isAnnotationPresent(InjectSeller.class))) {

                declaredField.setAccessible(true);
                if (sellers.isEmpty()) {
                    System.out.println("Seller list is empty");
                } else {
                    declaredField.set(bean, sellers.removeFirst());
                }
            }
        }
        return bean;
    }

}
