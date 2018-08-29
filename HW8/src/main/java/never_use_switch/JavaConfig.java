package never_use_switch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ComponentScan("never_use_switch")
public class JavaConfig {

    @Autowired
    AnnotationConfigApplicationContext context;

    @Bean
    Map<Integer, MailSender> getMailCodeMap() {
//        Map<String, MailSender> beansOfType = context.getBeansOfType(MailSender.class);

        Map<Integer, MailSender> intSemderMap = new HashMap<>();
        intSemderMap.put(1, new WelcomeMailSender());
        intSemderMap.put(2, new BirthdayMailSender());
        intSemderMap.put(3, new OloMailSender());

        return intSemderMap;
    }
}
