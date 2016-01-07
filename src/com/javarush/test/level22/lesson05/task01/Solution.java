package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException{
        if (string == null)
            throw new TooShortStringException();
        int i = string.indexOf(32);
        if (i<0) throw new TooShortStringException();
        i = string.indexOf(32, i+1);
        if (i<0) throw new TooShortStringException();
        i = string.indexOf(32, i+1);
        if (i<0) throw new TooShortStringException();
        i = string.indexOf(32, i+1);
        if (i<0) throw new TooShortStringException();

        return string.substring(string.indexOf(32) + 1, string.indexOf(32, i+1));

    }

    public static class TooShortStringException extends Exception {
    }

    public static void main (String[] Args)
    {
        try
        {
            System.out.println(getPartOfString("JavaRush - лу"));
        }
        catch (TooShortStringException e)
        {
            e.printStackTrace();
        }
    }
}
