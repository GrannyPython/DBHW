package aop_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.retry.annotation.EnableRetry;

@EnableAspectJAutoProxy
@EnableRetry
@Configuration
@ComponentScan("aop_project")
public class Main {
    @Autowired
    Endpoint endpoint;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext("aop_project");

        Endpoint bean = annotationConfigApplicationContext.getBean(Endpoint.class);

        while (true) {

            try {
                boolean connection = bean.getConnection();
                System.out.println("connection = " + connection);
            }
            catch (Exception e){
                System.out.println("failed");
                //IT IS NOT POSSIBLE !!1!
            }


        }
    }
}
