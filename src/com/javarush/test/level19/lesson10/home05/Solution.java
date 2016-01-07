package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));

        List<String> words = new ArrayList<>();

        while (reader.ready()) {
            String s = reader.readLine();
            int wstart = 0;

            for (int i = 0; i < s.length(); i++)
            {
                if (s.toCharArray()[i] == ' ') {
                    words.add(s.substring(0,i));

                    wstart = i++;
                    for (; i<s.length(); i++) {
                        if (s.toCharArray()[i] == ' ') {
                            words.add(s.substring(wstart, i));
                            wstart = i;
                        }
                        else if (i == s.length()-1) {
                            words.add(s.substring(wstart, ++i));
                        }
                    }
                }
                else if (i == s.length()-1) {
                    words.add(s.substring(0,i+1));
                }
            }
        }

        for (String s:words) {
            if (s.contains("0") || s.contains("1") || s.contains("2") || s.contains("3") || s.contains("4") || s.contains("5") ||
                    s.contains("6") || s.contains("7") || s.contains("8") || s.contains("9")) {
                if (s.contains(" ")) writer.write(s);
                else writer.write(" " + s);
            }
        }

        System.out.println(words);

        reader.close();
        writer.close();
    }
}
