package com.javarush.test.level14.lesson08.bonus01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        //Add your code here
        try //2
        {
            InputStream inputStream = new FileInputStream("s");
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        try //3
        {
            BufferedReader reader = new BufferedReader(null);
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        try //4
        {
            BufferedReader reader = new BufferedReader(null);
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        try //5
        {
            BufferedReader reader = new BufferedReader(null);
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        try //6
        {
            BufferedReader reader = new BufferedReader(null);
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        try //7
        {
            BufferedReader reader = new BufferedReader(null);
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        try //8
        {
            BufferedReader reader = new BufferedReader(null);
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        try //9
        {
            BufferedReader reader = new BufferedReader(null);
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        try //10
        {
            BufferedReader reader = new BufferedReader(null);
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

    }
}
