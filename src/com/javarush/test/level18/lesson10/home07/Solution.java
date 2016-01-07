package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки. Не использовать try-with-resources

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())));

        while (file.ready()) {
            String fileLine = file.readLine();

            StringBuilder sb = new StringBuilder("");
            for (char ch : fileLine.toCharArray()) {
                if (ch == 32 && sb.toString().equals(args[0])) {
                    System.out.println(fileLine);
                    break;
                }
                sb.append(ch);
            }
        }

        reader.close();
        file.close();
    }
}
