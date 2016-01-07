package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by jan on 5.09.15.
 */
public class Singleton
{
    static Singleton INSTANCE = null;
    private Singleton() {}

    static Singleton getInstance() {
        if (INSTANCE==null) {
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }
}
