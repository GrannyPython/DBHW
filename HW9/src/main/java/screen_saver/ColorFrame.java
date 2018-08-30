package screen_saver;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

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
    public void init() {
        setTitle(title);
        setSize(300, 300);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void moveToRandomLocation() {
        setLocation(random.nextInt(1600), random.nextInt(900));
        getContentPane().setBackground(color);
        repaint();
    }
}












