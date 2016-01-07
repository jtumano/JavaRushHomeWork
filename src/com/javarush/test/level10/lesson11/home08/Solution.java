package com.javarush.test.level10.lesson11.home08;

import com.javarush.test.level06.lesson08.task05.StringHelper;

import java.util.ArrayList;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {
        //напишите тут ваш код
        ArrayList<String>[] proov = new ArrayList[2];

        for (int i = 0 ; i<proov.length; i++)
        {
            proov[i] = new ArrayList<String>();
            proov[i].add("one");
            proov[i].add("two");
            proov[i].add("three");
        }

        return proov;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}