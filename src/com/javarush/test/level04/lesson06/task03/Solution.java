package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
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
        String cc = reader.readLine();

        int a = Integer.parseInt(aa);
        int b = Integer.parseInt(bb);
        int c = Integer.parseInt(cc);

        int min, mid, max;

        if (a<b && a<c)
            {
                min = a;
                if (b<c)
                    {
                        mid = b;
                        max = c;
                    }
                else
                    {
                        mid = c;
                        max = b;
                    }
            }
        else
            {
                if (b<a && b<c)
                    {
                        min = b;
                        if (a<c)
                            {
                                mid = a;
                                max = c;
                            }
                        else
                            {
                                mid = c;
                                max = a;
                            }
                    }
                else
                {
                    min = c;
                    if (a<b)
                        {
                            mid = a;
                            max = b;
                        }
                    else
                        {
                            mid = b;
                            max = a;
                        }
                }
            }
        System.out.println(max + " " + mid + " " + min);
    }
}
