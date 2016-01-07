package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s1 = reader.readLine();
        String s2 = reader.readLine();
        String s3 = reader.readLine();

        InputStream inputStream = new FileInputStream(s1);
        OutputStream outputStream1 = new FileOutputStream(s2);
        OutputStream outputStream2 = new FileOutputStream(s3);

        int tmp = inputStream.available()/2 + inputStream.available()%2;

        if (inputStream.available()%2 == 0)
        {
            while (inputStream.available() > tmp)
            {
                int data = inputStream.read();
                outputStream1.write(data);
            }
            while (inputStream.available()>0)
            {
                int data = inputStream.read();
                outputStream2.write(data);
            }
        }
        else
        {
            while (inputStream.available() >= tmp)
            {
                int data = inputStream.read();
                outputStream1.write(data);
            }
            while (inputStream.available()>0)
            {
                int data = inputStream.read();
                outputStream2.write(data);
            }
        }

        reader.close();
        inputStream.close();
        outputStream1.close();
        outputStream2.close();
    }
}
