package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        InputStream inputStream = new FileInputStream(s);

        Map<Integer, Integer> map = new HashMap<>();
        int maxbytekey = 0;
        int maxbytevalue = 0;

        while (inputStream.available()>0)
        {
            int data = inputStream.read();

            if (map.containsKey(data))
            {
                int tmp = map.get(data);
                map.put(data, ++tmp);
            }
            else
            {
                map.put(data, 1);
            }
        }

        reader.close();
        inputStream.close();

        for (Map.Entry<Integer, Integer> pair : map.entrySet())
        {
            if (pair.getValue() > maxbytevalue)
            {
                maxbytekey = pair.getKey();
                maxbytevalue = pair.getValue();
            }
        }

        System.out.print(maxbytekey);

        for (Map.Entry<Integer, Integer> pair : map.entrySet())
        {
            if (pair.getValue() == maxbytevalue)
            {
                if (pair.getKey() != maxbytekey)
                {
                    System.out.print(" " + pair.getKey());
                }
            }
        }

    }
}
