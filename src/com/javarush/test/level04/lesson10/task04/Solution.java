package com.javarush.test.level04.lesson10.task04;

import java.io.*;

/* S-квадрат
Вывести на экран квадрат из 10х10 букв S используя цикл while.
Буквы в одной строке не разделять.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        int a=0, b=0;

        while (a<10)
        {
            while (b<10)
            {
                System.out.print("S");
                b++;
            }
            System.out.println();
            a++;
            b=0;
        }
    }
}
