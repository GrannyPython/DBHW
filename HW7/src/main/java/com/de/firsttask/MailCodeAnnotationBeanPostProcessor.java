package com.de.firsttask;

import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.util.HashMap;
import java.util.Map;

public class MailCodeAnnotationBeanPostProcessor implements BeanPostProcessor {
    private Map<Integer, MailSender> mailCodesMap = new HashMap<>();

    {
        mailCodesMap.put(1, new WelcomeMailSender());
        mailCodesMap.put(2, new BirthdayMailSender());
    }


    @SneakyThrows
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        MailCode[] mailCodes = o.getClass().getAnnotationsByType(MailCode.class);
        for (MailCode mailCode : mailCodes) {
            MailSender mailSender = mailCodesMap.get(mailCode.value());
            mailSender.send();
        }


        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        return o;
    }

}
