package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String a = reader.readLine();
        String b = reader.readLine();
        String c = reader.readLine();
        String d = reader.readLine();

        int aa = Integer.parseInt(a);
        int bb = Integer.parseInt(b);
        int cc = Integer.parseInt(c);
        int dd = Integer.parseInt(d);

        if (aa>bb && aa>cc && aa>dd)
            System.out.println(aa);
        else
        {
            if (bb>aa && bb>cc && bb>dd)
                System.out.println(bb);
            else
            {
                if (cc>aa && cc>bb && cc>dd)
                    System.out.println(cc);
                else System.out.println(dd);
            }
        }
    }
}
