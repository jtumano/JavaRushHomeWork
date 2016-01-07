package com.javarush.test.level08.lesson03.task02;

/* HashMap из 10 пар
Создать коллекцию HashMap<String, String>, занести туда 10 пар строк:
арбуз – ягода, банан – трава, вишня – ягода, груша – фрукт, дыня – овощ, ежевика – куст, жень-шень – корень, земляника – ягода, ирис – цветок, картофель – клубень.
Вывести содержимое коллекции на экран, каждый элемент с новой строки.
Пример вывода (тут показана только одна строка):
картофель – клубень
*/

import com.javarush.test.level06.lesson08.task05.StringHelper;

import java.util.HashMap;
import java.util.Map;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        Map<String, String> list = new HashMap<String, String>();

        list.put("арбуз", "ягода");
        list.put("банан", "трава");
        list.put("вишня", "ягода");
        list.put("груша", "фрукт");
        list.put("дыня", "овощ");
        list.put("ежевика", "куст");
        list.put("жень-шень", "корень");
        list.put("земляника", "ягода");
        list.put("ирис", "цветок");
        list.put("картофель", "клубень");

        for (Map.Entry<String, String> pair : list.entrySet())
        {
            String key = pair.getKey();
            String value = pair.getValue();
            System.out.println(key + " - " + value);
        }
    }
}
