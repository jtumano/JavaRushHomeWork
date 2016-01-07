package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader fileIn = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fileOut = new BufferedWriter(new FileWriter(args[1]));
        List<String> list = new ArrayList<>();

        while (fileIn.ready()) {
            String[] s = fileIn.readLine().split(" ");
            for (int i = 0; i < s.length; i++)
            {
                list.add(s[i]);
            }
        }

        boolean isFirst = false;

        for (int i=0; i<list.size(); i++) {
            if (!isFirst) {
                if (list.get(i).length() > 6 ) {
                    fileOut.write(list.get(i));
                    isFirst = true;
                }
            }
            else {
                if (list.get(i).length() > 6) fileOut.write("," + list.get(i));
            }
        }
        fileOut.flush();

        fileIn.close();
        fileOut.close();
    }
}
