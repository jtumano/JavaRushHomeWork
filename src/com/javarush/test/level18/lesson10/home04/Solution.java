package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1 = reader.readLine();
        String file2 = reader.readLine();

        InputStream inputStream1 = new BufferedInputStream(new FileInputStream(file1));
        InputStream inputStream2 = new FileInputStream(file2);

        byte[] file1data = new byte[inputStream1.available()];

        inputStream1.read(file1data);



        OutputStream outputStream = new FileOutputStream(file1);



        while (inputStream2.available()>0)
        {
            int data = inputStream2.read();

            outputStream.write(data);
        }

        for (int i=0; i<file1data.length; i++)
        {
            outputStream.write(file1data[i]);
        }

        reader.close();
        inputStream1.close();
        inputStream2.close();
        outputStream.close();
    }
}
