package com.javarush.test.level14.lesson08.home09;

/**
 * Created by jan on 5.09.15.
 */
public class Hrivna extends Money
{
    public Hrivna(double amount)
    {
        super(amount);
    }

    public String getCurrencyName()
    {
        return "HRN";
    }

}
