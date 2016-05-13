package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by jan on 5/13/16.
 */
public class Order
{
    private Tablet tablet;

    private List<Dish> dishes;

    public Order(Tablet tablet) throws IOException
    {
        this.tablet = tablet;
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }

    @Override
    public String toString()
    {
        return dishes.isEmpty() ? "" : String.format("Your order: %s of %s", dishes, tablet);
    }

    public int getTotalCookingTime() {
        int time = 0;

        for (int i = 0; i < dishes.size(); i++)
        {
            time += dishes.get(i).getDuration();
        }

        return time;
    }

    public boolean isEmpty() {
        return dishes.isEmpty();
    }
}
