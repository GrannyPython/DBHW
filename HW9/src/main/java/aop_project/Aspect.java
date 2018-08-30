package aop_project;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.sql.SQLDataException;

@org.aspectj.lang.annotation.Aspect
@Component
public class Aspect {

    @AfterThrowing(pointcut = "execution(* aop_project.Dao.*(..))", throwing = "ex")
    public void logError(SQLDataException ex) {
        System.out.println(ex);
    }

    void someMethos(){};
}
