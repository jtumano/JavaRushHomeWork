package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader file1 =  new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter file2 =  new BufferedWriter(new FileWriter(reader.readLine()));

        List<String> words = new ArrayList<>();

        while (file1.ready()) {
            String s = file1.readLine();
            int pos =0;

            for (int i = 0; i < s.length(); i++)
            {
                if (s.toCharArray()[i] == ' ') {
                    words.add(s.substring(pos,i));
                    pos = i+1;
                }
                if (i == s.length()-1) {
                    words.add(s.substring(pos,i+1));
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (String s:words) {
            try
            {
                sb.append(Integer.parseInt(s));
                sb.append(" ");
            }
            catch (NumberFormatException e)
            {

            }
        }
        file2.write(sb.toString());
        file2.flush();

        reader.close();
        file1.close();
        file2.close();
    }
}
