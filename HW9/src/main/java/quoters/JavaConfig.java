package quoters;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import java.util.Arrays;
import java.util.List;

@Configuration
@PropertySource("classpath:quotes.properties")
@Profile("DUMMY")
public class JavaConfig {

    @Value("${termQuotes}")
    String termQuotes;

    @Bean
    public List<String> getTerminatorQuotes() {
        return Arrays.asList(termQuotes.split(","));
    }
}

