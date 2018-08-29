package com.de.firsttask;

public class OloMailSender implements MailSender {
    @Override
    public void send() {
        System.out.println("HB Sender!");
    }
}
