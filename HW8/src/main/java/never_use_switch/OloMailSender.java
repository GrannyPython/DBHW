package never_use_switch;

import org.springframework.stereotype.Component;

@Component
public class OloMailSender implements MailSender {
    @Override
    public void send() {
        System.out.println("OLO Sender!");
    }
}
