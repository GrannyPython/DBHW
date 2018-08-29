package screen_saver;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * @author Evgeny Borisov
 */
@RequiredArgsConstructor
public class ColorFrame extends JFrame {
    private final String title;

    @Autowired
    private Color color;

    private Random random = new Random();

    @PostConstruct
    public void init(){
        setTitle(title);
        setSize(300,300);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @SneakyThrows
    public void moveToRandomLocation() {
        setLocation(random.nextInt(1600),random.nextInt(900));
        getContentPane().setBackground(color);
        Thread.sleep(500);
        dispose();
    }














}













