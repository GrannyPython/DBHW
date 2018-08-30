package screen_saver;

import lombok.SneakyThrows;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Evgeny Borisov
 */
public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScreenSaverConfig.class);

        while (true) {
            context.getBean(ColorFrame.class).moveToRandomLocation();
            Thread.sleep(70);
        }
    }
}
