package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        InputStream inputStream = new FileInputStream(s);

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> sortlist = new ArrayList<>();
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
            sortlist.add(pair.getKey());
        }

        Collections.sort(sortlist);

        for (Integer i:sortlist)
        {
            System.out.print(i + " ");
        }
    }
}
