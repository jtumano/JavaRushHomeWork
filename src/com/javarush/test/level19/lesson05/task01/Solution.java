package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        InputStream inputFile = new FileInputStream(reader.readLine());
        OutputStream outputFile = new FileOutputStream(reader.readLine());

        boolean is4etnoe = true;

        while (inputFile.available() > 0) {
            if (inputFile.available() % 2 == 0) {
                inputFile.read();
            }
            else
                outputFile.write(inputFile.read());
        }

        reader.close();
        inputFile.close();
        outputFile.close();
    }
}
