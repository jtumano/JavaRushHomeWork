package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputStream inputStream = new FileInputStream(reader.readLine());
        OutputStream outputStream = new FileOutputStream(reader.readLine());

        while (inputStream.available()>0) {
            int data = inputStream.read();

            if (Character.isAlphabetic(data) || Character.isDigit(data)) outputStream.write(data);
        }

        reader.close();
        inputStream.close();
        outputStream.close();
    }
}
