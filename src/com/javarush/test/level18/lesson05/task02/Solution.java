package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки. Не использовать try-with-resources

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputStream inputStream = new FileInputStream(reader.readLine());

        int commasCount=0;

        while (inputStream.available()>0)
        {
            int data = inputStream.read();
            if (data==44)
                commasCount++;
        }
        System.out.println(commasCount);

        reader.close();
        inputStream.close();
    }
}
