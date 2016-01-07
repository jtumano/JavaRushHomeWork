package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        OutputStream out = new PrintStream(System.out);

        String s = reader.readLine();

        InputStream inStream = new FileInputStream(s);

        while (inStream.available()>0)
        {
            int data = inStream.read();
            out.write(data);
        }

        inStream.close();
        out.close();
        reader.close();
    }
}
