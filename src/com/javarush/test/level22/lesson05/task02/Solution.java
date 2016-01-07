package com.javarush.test.level22.lesson05.task02;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException{
        if (string == null) throw new TooShortStringException();

        int i = string.indexOf('\t');
        if (i<0) throw new TooShortStringException();

        i = string.indexOf('\t', i+1);
        if (i<0) throw new TooShortStringException();

        return string.substring(string.indexOf((char)9) + 1, string.indexOf((char)9, i));
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main (String[] Args)
    {
        try
        {
            System.out.println(getPartOfString("\tjjsd"));
        }
        catch (TooShortStringException e)
        {
            e.printStackTrace();
        }
    }
}
