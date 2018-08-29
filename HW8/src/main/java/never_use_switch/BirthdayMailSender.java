package never_use_switch;

import org.springframework.stereotype.Component;

@Component
public class BirthdayMailSender implements MailSender {
    @Override
    public void send() {
        System.out.println("HB Sender!");
    }
}
