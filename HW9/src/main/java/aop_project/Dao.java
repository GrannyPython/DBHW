package aop_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLDataException;

@Component
public class Dao {
    @Autowired
    Database database;


    boolean getConnection() throws SQLDataException {
        return database.getConnection();
    }
}
