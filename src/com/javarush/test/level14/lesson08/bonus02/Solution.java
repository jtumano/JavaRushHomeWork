package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int i1 = Integer.parseInt(reader.readLine());
        int i2 = Integer.parseInt(reader.readLine());
        int imax;
        int ii;
        int nod=1;

        if (i1<i2)
        {
            imax=i1;
            ii = i2;
        }
        else
        {
            imax=i2;
            ii = i1;
        }

        for (int i=1; i<=imax; i++)
        {
            if (i1 % i == 0 && i2 % i == 0)
                nod = i;
        }
        System.out.println(nod);
    }
}
