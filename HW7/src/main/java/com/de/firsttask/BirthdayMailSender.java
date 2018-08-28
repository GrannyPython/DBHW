package com.de.firsttask;

public class BirthdayMailSender implements MailSender {
    @Override
    public void send() {
        System.out.println("HB Sender!");
    }
}
