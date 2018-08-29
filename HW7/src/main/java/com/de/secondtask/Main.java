package com.de.secondtask;


import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {


    public static void main(String[] args) {
        new FileSystemXmlApplicationContext("src\\main\\resources\\spring-config-homework-second.xml");
    }
}
