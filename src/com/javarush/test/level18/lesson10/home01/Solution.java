package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        InputStream inputStream = new FileInputStream(args[0]);
        List<Integer> list = new ArrayList<>();
        int countEngWords = 0;

        while (inputStream.available()>0)
        {
            int data = inputStream.read();
            if (data >= (int) 'a' && data <= (int) 'z')
            {
                countEngWords++;
            }
            if (data >= (int) 'A' && data <= (int) 'Z')
            {
                countEngWords++;
            }
        }

        inputStream.close();

        System.out.println(countEngWords);
    }
}
