package com.de.secondtask;

public class Market {
    @InjectSeller
    Seller counter0;

    @InjectSeller
    Seller counter1;

    @InjectSeller
    Seller counter2;


    public void printMarketState(){
        System.out.println(counter0);
        System.out.println(counter1);
        System.out.println(counter2);
    }
}
