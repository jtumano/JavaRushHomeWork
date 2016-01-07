package com.javarush.test.level08.lesson08.task01;

import java.util.HashSet;
import java.util.Set;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution
{
    public static HashSet<String> createSet()
    {
        //напишите тут ваш код
        HashSet<String> mnozestvo = new HashSet<String>();

        mnozestvo.add("Ложка");
        mnozestvo.add("Ломка");
        mnozestvo.add("Лодка");
        mnozestvo.add("Ляжка");
        mnozestvo.add("Лурк");
        mnozestvo.add("Лида");
        mnozestvo.add("Лана");
        mnozestvo.add("Лара");
        mnozestvo.add("Лера");
        mnozestvo.add("Леонтьев");
        mnozestvo.add("Леонид");
        mnozestvo.add("Лох");
        mnozestvo.add("Ламер");
        mnozestvo.add("Лидо");
        mnozestvo.add("Лукас");
        mnozestvo.add("Ломпопо");
        mnozestvo.add("Ларин");
        mnozestvo.add("Литл");
        mnozestvo.add("Левиафан");
        mnozestvo.add("Лимон");

        return mnozestvo;
    }
}
