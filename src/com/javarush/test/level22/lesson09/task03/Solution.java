package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file = new BufferedReader(new FileReader(reader.readLine()));

        List<String> list = new ArrayList<>();

        while (file.ready()) {
            String s = file.readLine().trim();
            int algPos = 0;

            for (int i = 0; i < s.length(); i++)
            {
                if (s.charAt(i) == ' ') {
                    list.add(s.substring(algPos, i).trim());
                    algPos = i;
                }
                else if (i == s.length()-1) {
                    list.add(s.substring(algPos).trim());
                    algPos = 0;
                }
            }
        }

        String[] words = new String[list.size()];
        words = list.toArray(words);

        //...
        StringBuilder result = getLine(words);
        System.out.println(result.toString());

        reader.close();
        file.close();
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder sb = new StringBuilder();

        if (words == null || words.length == 0)
            return new StringBuilder();
        if (words[0].equals(""))
            return new StringBuilder(words[0]);
        if (!words[0].isEmpty() && words.length == 1){
            return new StringBuilder(words[0]);
        }


        List<String> list = Arrays.asList(words);

        int counter = 0;

        while (counter < words.length)
        {
            Collections.shuffle(list);

            counter = 0;
            if (sb.length()>0)
            {
                sb.delete(0, sb.length());
            }

            sb.append(words[0] + " ");
            counter++;

            for (String s:list)
            {
                if (sb.substring(sb.length()-2, sb.length()-1).equalsIgnoreCase(s.substring(0,1))) {
                    sb.append(s + " ");
                    counter++;
                }
            }
        }

        sb.delete(sb.length()-1, sb.length());

        return sb;
    }
}
