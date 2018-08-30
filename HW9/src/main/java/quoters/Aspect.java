package quoters;

import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.stereotype.Component;


@Component
@org.aspectj.lang.annotation.Aspect
public class Aspect {

    @Around("execution(* quoters.Main.log(..))")
    @SneakyThrows
    public Object logAll(ProceedingJoinPoint joinPoint) {

        System.out.println("joinPoint = " + joinPoint.getSignature().getName());
        joinPoint.proceed();
        return joinPoint;
    }

}
