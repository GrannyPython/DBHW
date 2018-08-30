package quoters;

import javafx.beans.property.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${termQuotes}")
    String termQuotes;

    @Bean
    public List<String> getTerminatorQuotes() {
        return Arrays.asList(termQuotes.split(","));
    }
}

