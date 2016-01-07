package com.javarush.test.level09.lesson11.home03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
Вводить с клавиатуры числа. Код по чтению чисел с клавиатуры вынести в отдельный метод. Обернуть все тело (весь код)
этого метода в try..catch.
Если пользователь ввёл какой-то текст, вместо ввода числа, функция должна перехватить исключение и вывести все
введенные числа в качестве результата.
 */
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        readData();
    }

    public static void readData() throws IOException
    {
        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        try
        {
            while ( true )
            {
                int nextNumber = Integer.parseInt( reader.readLine() );
                numbers.add( nextNumber );
            }
        }
        catch ( NumberFormatException e )
        {
            for ( int n : numbers )
            {
                System.out.println( n );
            }
        }
    }
}