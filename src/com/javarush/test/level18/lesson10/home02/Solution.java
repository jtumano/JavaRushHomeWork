package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран частоту встречания пробела. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        InputStream inputStream = new FileInputStream(args[0]);
        int symbolCount = 0;
        int spaceCount = 0;

        while (inputStream.available()>0)
        {
            int data = inputStream.read();
            symbolCount++;
            if (data == (int) ' ')
            {
                spaceCount++;
            }
        }
        inputStream.close();

        double a = (float) spaceCount*1.0 / (float) symbolCount * 100;

        System.out.printf("%.2f", a);
    }
}
