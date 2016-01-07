package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();

        String file = "";

        while (true) {
            String s = reader.readLine();
            if (s.equals("end")) break;
            else list.add(s);
        }

        for (int i=list.get(0).toCharArray().length-1; i>=0; i--) {
            if (list.get(0).toCharArray()[i] == 46) {
                file = list.get(0).substring(0,i);
                break;
            }
        }

        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file));

        Collections.sort(list);

        byte[] buffer = new byte[1000];

        for (String s : list) {
            BufferedInputStream is = new BufferedInputStream(new FileInputStream(s));
            while (is.available()>0) {
                int count = is.read(buffer);
                outputStream.write(buffer, 0, count);
            }
            is.close();
        }

        reader.close();
        outputStream.close();
    }
}
