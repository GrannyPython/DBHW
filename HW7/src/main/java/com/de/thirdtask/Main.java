package com.de.thirdtask;

import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        FileSystemXmlApplicationContext fileSystemXmlApplicationContext = new FileSystemXmlApplicationContext("C:\\Users\\GP\\IdeaProjects\\DBHWAnd\\HW7\\src\\main\\resources\\spring-config-homework-third.xml");
        Unit unit = fileSystemXmlApplicationContext.getBean("unit", Unit.class);
        unit.doSmth();
    }
}
