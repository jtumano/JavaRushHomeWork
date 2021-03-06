package com.javarush.test.level26.lesson15.big01;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jan on 5/9/16.
 */
public class CurrencyManipulatorFactory
{
    private static CurrencyManipulatorFactory ourInstance = new CurrencyManipulatorFactory();
    private static Map<String, CurrencyManipulator> manipulatorMap = new HashMap<>();

    private CurrencyManipulatorFactory()
    {
    }

    public static CurrencyManipulatorFactory getInstance()
    {
        return ourInstance;
    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        if (!manipulatorMap.containsKey(currencyCode)) manipulatorMap.put(currencyCode, new CurrencyManipulator(currencyCode));
        return manipulatorMap.get(currencyCode);
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators()
    {
        return manipulatorMap.values();
    }
}
