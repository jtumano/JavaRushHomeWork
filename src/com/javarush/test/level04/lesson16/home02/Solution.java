package com.javarush.test.level04.lesson16.home02;

import java.io.*;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String aarv1 = reader.readLine();
        String aarv2 = reader.readLine();
        String aarv3 = reader.readLine();

        int a = Integer.parseInt(aarv1);
        int b = Integer.parseInt(aarv2);
        int c = Integer.parseInt(aarv3);

        if ((a<b && a>c) || (a>b && a<c))
            System.out.println(a);
        else
        {
            if ((b<a && b>c) || (b>a && b<c))
                System.out.println(b);
            else
                System.out.println(c);
        }
    }
}
