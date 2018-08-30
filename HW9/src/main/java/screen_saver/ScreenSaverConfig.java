package screen_saver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

import javax.annotation.PostConstruct;
import java.awt.*;
import java.util.Random;

@Configuration
@ComponentScan
public class ScreenSaverConfig {

    @Autowired
    ConfigurableBeanFactory beanFactor;

    @PostConstruct
    void init(){
        beanFactor.registerScope("custom2SecScope", new Custom2SecScope());
    }


    private Random random = new Random();
    @Value("${JAVA_HOME}")
    private String javaHome;

    @Bean
    public ColorFrame frame() {
        return new ColorFrame(javaHome);
    }

    @Bean
    @Scope(value = "custom2SecScope", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Color color() {
        Color color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
        System.out.println("color = " + color);
        return color;
    }


}
