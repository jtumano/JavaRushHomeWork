package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException{
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> params = new ArrayList<>();

        String s = reader.readLine();
        int pos;

        for (int i = 0; i < s.length(); i++)
        {
            if (s.toCharArray()[i] == '?') {
                pos = i+1;
                for (; i<s.length(); i++)
                {
                    if (s.toCharArray()[i] == '&'){
                        params.add(s.substring(pos,i));
                        pos = i+1;
                    }
                    else if (s.toCharArray()[i] == '=') {
                        params.add(s.substring(pos, i));
                        for (; i<s.length(); i++) {
                            if (s.toCharArray()[i] == '&') {
                                pos = i+1;
                                break;
                            }
                        }
                    }
                    else if (i == s.length()-1) {
                        params.add(s.substring(pos,i+1));
                    }
                }
            }
        }

        for (String ss:params) {
            System.out.print(ss + " ");
        }
        System.out.println();

        if (s.contains("?obj=") || s.contains("&obj=")) {
            for (int i = 0; i < s.length(); i++)
            {
                if (s.toCharArray()[i] == '?' || s.toCharArray()[i] == '&') {
                    if (i+1<s.length() && s.toCharArray()[i+1] == 'o') {
                        if (i+2<s.length() && s.toCharArray()[i+2] == 'b') {
                            if (i+3<s.length() && s.toCharArray()[i+3] == 'j') {
                                if (i+4<s.length() && s.toCharArray()[i+4] == '=') {
                                    pos=i+5;
                                    for (i=i+5; i<s.length(); i++) {
                                        if (s.toCharArray()[i] == '&') {
                                            try
                                            {
                                                alert(Double.parseDouble(s.substring(pos,i)));
                                            }
                                            catch (NumberFormatException e)
                                            {
                                                alert(s.substring(pos,i));
                                            }
                                            break;
                                        }
                                        else if (i == s.length()-1) {
                                            try
                                            {
                                                alert(Double.parseDouble(s.substring(pos,i+1)));
                                            }
                                            catch (NumberFormatException e)
                                            {
                                                alert(s.substring(pos,i+1));
                                            }
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        reader.close();
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
