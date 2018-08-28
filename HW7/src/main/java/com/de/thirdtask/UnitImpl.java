package com.de.thirdtask;


public class UnitImpl implements Unit{
    @Transaction
    @Benchmark
    @Trademark
    public void doSmth(){
        System.out.println("Some UnitImpl Logic");
    }
}
