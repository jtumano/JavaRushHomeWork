package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file = new BufferedReader(new FileReader(reader.readLine()));

        List<String> words = new ArrayList<>();
        List<String> worldWords = new ArrayList<>();

        while (file.ready()) {
            String s = file.readLine();
            
            int markerpos;

            for (int i = 0; i < s.length(); i++)
            {
                if (!Character.isLetterOrDigit(s.toCharArray()[i])) {
                    words.add(s.substring(0,i));
                    markerpos = i;

                    for (; i < s.length(); i++)
                    {
                        if (!Character.isLetterOrDigit(s.toCharArray()[i])) {
                            words.add(s.substring(markerpos, i));
                            markerpos = i;
                        }
                        else if (i == s.length()-1) {
                            words.add(s.substring(markerpos, i+1));
                        }
                    }
                }
                else if (i == s.length()-1) {
                    words.add(s.substring(0, i+1));
                }
            }
        }

        int count=0;

        for (String s:words) {
            if (s.contains("world")) worldWords.add(s);
        }
        for (String s:worldWords) {
            for (int i = 0; i < s.length(); i++)
            {
                if (s.toCharArray()[i] == 'w') {
                    if (i+1<s.length() && s.toCharArray()[i+1] == 'o') {
                        if (i+2<s.length() && s.toCharArray()[i+2] == 'r') {
                            if (i+3<s.length() && s.toCharArray()[i+3] == 'l') {
                                if (i+4<s.length() && s.toCharArray()[i+4] == 'd') {
                                    if (i+5<s.length() && i-1>=0 && !Character.isLetterOrDigit(s.toCharArray()[i-1]) && !Character.isLetterOrDigit(s.toCharArray()[i+5])) {
                                        System.out.println("ss");
                                    }
                                    else if (i+4 == s.length()-1 && i-1 >=0 && !Character.isLetterOrDigit(s.toCharArray()[i-1])) {
                                        count++;
                                    }
                                    else if (i == 0 && i+4 < s.length() && !Character.isLetterOrDigit(s.toCharArray()[i+4])){
                                        count++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(count);

        reader.close();
        file.close();
    }
}