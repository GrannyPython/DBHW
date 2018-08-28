package com.de.firsttask;


import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {


    public static void main(String[] args) {
        new FileSystemXmlApplicationContext("C:\\Users\\GP\\IdeaProjects\\DBHWAnd\\HW7\\src\\main\\resources\\spring-config-homework.xml");
    }
}
