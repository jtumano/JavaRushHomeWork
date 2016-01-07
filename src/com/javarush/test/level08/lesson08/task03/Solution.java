package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        HashMap<String, String> mapa = new HashMap<String, String>();

        mapa.put("Tumanov", "Jan");
        mapa.put("Liesenberg", "Albert");
        mapa.put("Muhhanov", "Mstislav");
        mapa.put("Einstein", "Albert");
        mapa.put("Krutojaicev", "Mihhail");
        mapa.put("Galustjan", "Mihhail");
        mapa.put("Pukin", "Ooli");
        mapa.put("Lulin", "Loh");
        mapa.put("Hrenov", "Kozel");
        mapa.put("Tupoi", "Loh");

        return mapa;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        int numberOfsameNames = 0;

        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();

        while (iterator.hasNext())
        {
            Map.Entry<String, String> pair = iterator.next();
            if (pair.getValue().equals(name))
                numberOfsameNames++;
        }
        return numberOfsameNames;

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya)
    {

        //напишите тут ваш код
        int numberOfsameNames = 0;

        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();

        while (iterator.hasNext())
        {
            Map.Entry<String, String> pair = iterator.next();
            if (pair.getKey().equals(familiya))
                numberOfsameNames++;
        }
        return numberOfsameNames;
    }


}
