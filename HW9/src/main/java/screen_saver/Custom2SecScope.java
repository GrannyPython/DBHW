package screen_saver;

import lombok.SneakyThrows;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.time.LocalDateTime;

@Component
public class Custom2SecScope implements Scope {
    Color color;
    LocalDateTime deathTime;

    @Override
    @SneakyThrows
    public Object get(String name, ObjectFactory<?> objectFactory) {
        if ((color == null) || deathTime == null) {
            color = (Color) objectFactory.getObject();
            deathTime = LocalDateTime.now().plusSeconds(2);
            return color;
        }

        if (LocalDateTime.now().isAfter(deathTime)) {
            color = (Color) objectFactory.getObject();
            deathTime = LocalDateTime.now().plusSeconds(2);
        }

        return color;


    }

    @Override
    public Object remove(String name) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String s, Runnable runnable) {
        System.out.println();
    }

    @Override
    public Object resolveContextualObject(String s) {
        return null;
    }

    @Override
    public String getConversationId() {
        return "olo";
    }
}
