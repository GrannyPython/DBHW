package never_use_switch;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Map;

@Configuration
@EnableScheduling
@ComponentScan("never_use_switch")
public class JavaConfig {

    @Autowired
    ApplicationContext applicationContext;

    @Bean
    Map<String, MailGenerator> getMap() {
        return applicationContext.getBeansOfType(MailGenerator.class);
    }
}
