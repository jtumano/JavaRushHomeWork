package com.javarush.test.level14.lesson08.home09;

/**
 * Created by jan on 5.09.15.
 */
public class USD extends Money
{
    public USD(double amount)
    {
        super(amount);
    }

    public String getCurrencyName()
    {
        return "USD";
    }
}
