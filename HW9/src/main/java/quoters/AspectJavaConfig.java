package quoters;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableAspectJAutoProxy
@PropertySource("classpath:quotes.properties")
@Profile("ASPECT")
public class AspectJavaConfig {

    @Value("${termQuotes}")
    String termQuotes;

    @Bean
    public List<String> getTerminatorQuotes() {
        return Arrays.asList(termQuotes.split(","));
    }
}

