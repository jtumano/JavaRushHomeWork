package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        OutputStream outputStream = new FileOutputStream(reader.readLine());
        InputStream inputStream1 = new FileInputStream(reader.readLine());
        InputStream inputStream2 = new FileInputStream(reader.readLine());

        while (inputStream1.available()>0)
        {
            int data = inputStream1.read();
            outputStream.write(data);
        }

        while (inputStream2.available()>0)
        {
            int data = inputStream2.read();
            outputStream.write(data);
        }

        reader.close();
        outputStream.close();
        inputStream1.close();
        inputStream2.close();
    }
}
