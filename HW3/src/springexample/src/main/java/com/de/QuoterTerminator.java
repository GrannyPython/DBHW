package springexample.src.main.java.com.de;

import java.util.List;
import java.util.Random;

public class QuoterTerminator implements Quoter {
    List<String> quotes;

    public void setQuotes(List<String> quotes) {
        this.quotes = quotes;
    }

    Random rand = new Random();


    private String getRandomQuote() {
        return quotes.get(rand.nextInt(quotes.size()));

    }

    public void say() {
        System.out.println(getRandomQuote());
    }
}
