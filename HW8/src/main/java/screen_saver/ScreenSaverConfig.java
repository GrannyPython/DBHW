package screen_saver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.awt.*;
import java.util.Random;

/**
 * @author Evgeny Borisov
 */
@Configuration
@ComponentScan
public class ScreenSaverConfig {

    private Random random = new Random();
    @Value("${JAVA_HOME}")
    private String javaHome;

    @Bean
    @Scope("prototype")
    public ColorFrame frame(){
        ColorFrame colorFrame = new ColorFrame(javaHome);
        return colorFrame;
    }

    @Bean
    @Scope("prototype")
    public Color color(){
        Color color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
        return color;
    }















}
