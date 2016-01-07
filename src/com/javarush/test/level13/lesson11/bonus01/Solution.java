package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();

        Scanner s = null;

        try {
            s = new Scanner(new BufferedReader(new FileReader(reader.readLine())));

            while (s.hasNext()) {
                list.add(Integer.parseInt(s.next()));
            }
        } finally {
            if (s != null) {
                s.close();
            }
        }

        for (Integer i : list)
        {
            if (i%2==0)
                list2.add(i);
        }

        Collections.sort(list2);

        for (Integer i : list2)
            System.out.println(i);
    }
}
