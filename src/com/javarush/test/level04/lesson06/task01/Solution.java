package com.javarush.test.level04.lesson06.task01;

/* Минимум двух чисел
Ввести с клавиатуры два числа, и вывести на экран минимальное из них.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String aa = reader.readLine();
        String bb = reader.readLine();
        int a = Integer.parseInt(aa);
        int b = Integer.parseInt(bb);

        if (a < b)
            System.out.println(a);
        else
            System.out.println(b);
    }
}