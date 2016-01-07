package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader file1 = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())));
        BufferedWriter file2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(reader.readLine())));

        String nomera;

        nomera = file1.readLine();

        StringBuilder sb = new StringBuilder("");

        List<Float> list = new ArrayList<>();

        for (char ch : nomera.toCharArray()) {
            if (ch == 32) {
                list.add(Float.parseFloat(sb.toString()));
                sb.delete(0, sb.length());
            }
            else {
                sb.append(ch);
            }
        }
        list.add(Float.parseFloat(sb.toString()));
        sb.delete(0, sb.length());

        DecimalFormat format = new DecimalFormat("#");

        for (Float fl : list)
        {
            if (fl % 0.5 == 0 && fl < 0) {
                sb.append(format.format(fl+0.1));
                sb.append(" ");
            }
            else {
                sb.append(format.format(fl));
                sb.append(" ");
            }

        }

        file2.write(sb.toString());

        reader.close();
        file1.close();
        file2.close();
    }
}
