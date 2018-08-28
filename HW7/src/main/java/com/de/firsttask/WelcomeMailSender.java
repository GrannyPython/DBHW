package com.de.firsttask;

public class WelcomeMailSender implements MailSender {
    @Override
    public void send() {
        System.out.println("Welcome Sender");
    }
}
