package never_use_switch;

import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
public class MailCodeAnnotationBeanPostProcessor implements BeanPostProcessor {

    @Autowired
    private Map<Integer, MailSender> mailCodeMap;

    @SneakyThrows
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        MailCode[] mailCodes = o.getClass().getAnnotationsByType(MailCode.class);
        for (MailCode mailCode : mailCodes) {
            MailSender mailSender = mailCodeMap.get(mailCode.value());
            mailSender.send();
        }


        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        return o;
    }

}
