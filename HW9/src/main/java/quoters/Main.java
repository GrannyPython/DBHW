package quoters;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author Evgeny Borisov
 */


//-Dspring.profiles.active=ASPECT


@Configuration
@EnableScheduling
public class Main {

    @Scheduled(fixedDelay = 1000)
    void log() {
        System.out.println("log method");
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("quoters");

    }
}
