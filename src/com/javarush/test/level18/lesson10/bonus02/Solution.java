package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file = reader.readLine();

        BufferedReader fileRead = new BufferedReader(new FileReader(file));

        List<String> articles = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();

        numbers.add(0);

        while (fileRead.ready()) {
            articles.add(fileRead.readLine());
        }
        fileRead.close();

        BufferedWriter fileWrite = new BufferedWriter(new FileWriter(file));

        for (String s:articles) {
            fileWrite.write(s + "\r\n");
        }

        for (String s:articles) {
            if (!s.equals("")) {
                String str = s.substring(0,8);
                StringBuilder numba = new StringBuilder();
                for (int i = 0; i < str.length(); i++)
                {
                    if (str.toCharArray()[i] != ' ') {
                        numba.append(str.toCharArray()[i]);
                    }
                }
                numbers.add(Integer.parseInt(numba.toString()));
                numba.delete(0,numba.length());
            }
        }
        Collections.sort(numbers);

        StringBuilder prodNameArgs = new StringBuilder();

        for (int i = 1; i < args.length-2; i++)
        {
            prodNameArgs.append(args[i] + " ");
        }

        String id = String.valueOf(numbers.get(numbers.size()-1) + 1);
        String productName;
        String price;
        String qty;

        if (id.length()<8) {
            StringBuilder probels = new StringBuilder();
            for (int i = 0; i < 8-id.length(); i++)
            {
                probels.append(" ");
            }
            id = id + probels.toString();
        }
        else if (id.length()>8) {
            id = id.substring(0,8);
        }

        if (prodNameArgs.length()<30) {
            StringBuilder probels = new StringBuilder();
            for (int i = 0; i < 30-prodNameArgs.length(); i++)
            {
                probels.append(" ");
            }
            productName = prodNameArgs + probels.toString();
        }
        else if (prodNameArgs.length()>30) {
            productName = prodNameArgs.substring(0,30);
        }
        else productName = prodNameArgs.toString();

        if (args[args.length-2].length()<8) {
            StringBuilder probels = new StringBuilder();
            for (int i = 0; i < 8-args[args.length-2].length(); i++)
            {
                probels.append(" ");
            }
            price = args[args.length-2] + probels.toString();
        }
        else if (args[args.length-2].length()>8) {
            price = args[args.length-2].substring(0,8);
        }
        else price = args[args.length-2];

        if (args[args.length-1].length() > 4) {
            qty = args[args.length-1].substring(0,4);
        }
        else if (args[args.length-1].length() < 4) {
            qty = args[args.length-1];
            while (qty.length() < 4) {
                qty += " ";
            }
        }
        else qty = args[args.length-1];

        fileWrite.write(id+productName+price+qty);

        fileWrite.flush();

        reader.close();
        fileWrite.close();
    }
}
