package never_use_switch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Evgeny Borisov
 */


@Component
public class MailSenderImpl implements MailSender {

    @Autowired
    private MailDao mailDao;

    @Autowired
    private Map<String, MailGenerator> generatorMap;


    @Scheduled(fixedDelay = 1000)
    public void sendMail() {
        MailInfo mailInfo = mailDao.getMailInfo();
        String mailCode = String.valueOf(mailInfo.getMailCode());
        MailGenerator mailGenerator = generatorMap.getOrDefault(mailCode, mailInfo1 -> {
            throw new UnsupportedOperationException(mailCode + " not supported yet");
        });

        String html = mailGenerator.generateHtml(mailInfo);
        send(html, mailInfo);

    }

    private void send(String html, MailInfo mailInfo) {
        //20 lines of code
        System.out.println("Sending to " + mailInfo.getClientMail());
        System.out.println("html = " + html);
    }
}







