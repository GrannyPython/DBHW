package quoters;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Component
public class Shakespeare implements Quoter {

    @Value("${shake}")
    private String message;

    @InjectRandomInt(min = 3, max = 5)
    private int repeat;


    @Override
    public void sayQuote() {
        for (int i = 0; i < repeat; i++) {
            System.out.println(message);
        }
    }
}







