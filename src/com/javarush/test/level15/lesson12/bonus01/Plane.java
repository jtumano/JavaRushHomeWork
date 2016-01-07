package com.javarush.test.level15.lesson12.bonus01;

/**
 * Created by jan on 5.09.15.
 */
public class Plane implements Flyable
{
    int passengersAmount;

    Plane(int passengersAmount)
    {
        this.passengersAmount = passengersAmount;
    }

    @Override
    public void fly()
    {

    }
}
