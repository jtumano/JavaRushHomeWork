package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created by jan on 6.09.15.
 */
public class TeaMaker extends DrinkMaker
{

    @Override
    public void getRightCup()
    {
        System.out.println("Берем чашку для чая");
    }

    @Override
    public void pour()
    {
        System.out.println("Заливаем водой");
    }

    @Override
    public void putIngredient()
    {
        System.out.println("Насыпаем чай");
    }
}
