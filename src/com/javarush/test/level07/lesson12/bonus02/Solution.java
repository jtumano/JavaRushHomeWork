package com.javarush.test.level07.lesson12.bonus02;

import com.javarush.test.level06.lesson08.task05.StringHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Нужно добавить в программу новую функциональность
Задача:  Программа вводит строки, пока пользователь не введёт пустую строку (нажав enter). Потом она конвертирует строки
в верхний регистр (Мама превращается в МАМА) и выводит их на экран.
Новая задача: Программа вводит строки, пока пользователь не введёт пустую строку (нажав enter).
Потом программа строит новый список. Если в строке чётное число букв, строка удваивается, если нечётное – утраивается.
Программа выводит содержимое нового списка на экран.
Пример ввода:
Кот
Коты
Я
Пример вывода:
Кот Кот Кот
Коты Коты
Я Я Я
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        while (true)
        {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        ArrayList<String> listnew = new ArrayList<String>();

        for (int i=0; i<list.size(); i++)
        {
            String temp = list.get(i);
            if (temp.length() % 2 == 0)
            {
                listnew.add(temp);
                listnew.add(temp);
            }
            else
            {
                listnew.add(list.get(i));
                listnew.add(list.get(i));
                listnew.add(list.get(i));
                //i=i+3;
            }

        }

        for(String s:listnew)
            System.out.println(s);

        /*
        ArrayList<String> listUpperCase = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++)
        {
            String s = list.get(i);
            listUpperCase.add(s.toUpperCase());
        }

        for (int i = 0; i < listUpperCase.size(); i++)
        {
            System.out.println(listUpperCase.get(i));
        }
        */
    }
}
