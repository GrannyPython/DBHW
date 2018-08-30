package aop_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLDataException;

@Component("Endpoint")
public class Endpoint {
    @Autowired
    Service service;

    boolean getConnection() throws SQLDataException {
        boolean connection = service.getConnection();



        return connection;
    }
}
