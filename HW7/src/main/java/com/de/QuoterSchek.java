package com.de;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class QuoterSchek implements Quoter {
    String quote;

    @InjectRandomInt(min = 3, max = 5)
    int repeat;

    public void say() {
        for (int i = 0; i < repeat; i++) {
            System.out.println(quote);
        }
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}
