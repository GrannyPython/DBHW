package my_spring;


import javax.annotation.PostConstruct;

/**
 * @author Evgeny Borisov
 */
public class IRobot {
    @InjectByType
    private Speaker speaker;
    @InjectByType
    private Cleaner cleaner;

    @PostConstruct
    public void init() {
        System.out.println(speaker.getClass().getSimpleName());
    }

    public void cleanRoom(){
        speaker.speak("Я начал работать!!!");
        cleaner.clean();
        speaker.speak("Я закончил работать!!!");
    }
}
