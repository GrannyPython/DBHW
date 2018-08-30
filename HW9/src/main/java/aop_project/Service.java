package aop_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLDataException;

@Component
public class Service {
    @Autowired
    Dao dao;

    boolean getConnection() throws SQLDataException {
        return dao.getConnection();
    }
}
