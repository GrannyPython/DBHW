package aop_project;

import lombok.SneakyThrows;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

import java.sql.SQLDataException;
import java.util.Random;


@Component
public class Database {

    public static Random RANDOM = new Random();


    @Retryable(
            value = {SQLDataException.class},
            maxAttempts = 5, backoff = @Backoff(500))
    boolean getConnection() throws SQLDataException {
        int i = RANDOM.nextInt(10);
        System.out.println(i);
        if (i >= 9)
            return true;
        else throw new SQLDataException();
    }
}
