package never_use_switch;

import lombok.SneakyThrows;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Evgeny Borisov
 */

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext("never_use_switch");

        MailSender bean = annotationConfigApplicationContext.getBean(MailSenderImpl.class);

        System.out.println("bean = " + bean);


    }
}
