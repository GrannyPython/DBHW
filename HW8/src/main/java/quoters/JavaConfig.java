package quoters;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Arrays;
import java.util.List;

@Configuration
@ComponentScan("quoters")
@PropertySource("classpath:quotes.properties")
public class JavaConfig {

    @Bean
    public List<String> getTerminatorQuotes() {
        return Arrays.asList("Trust me", "I'll be back", "Astalavista baby");
    }
}

