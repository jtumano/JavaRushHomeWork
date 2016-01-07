package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

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
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file = reader.readLine();

        BufferedReader fileRead = new BufferedReader(new FileReader(file));

        List<String> articles = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();

        while (fileRead.ready()) {
            articles.add(fileRead.readLine());
        }
        fileRead.close();

        BufferedWriter fileWrite = new BufferedWriter(new FileWriter(file));

        int index = 0;

        if (args[0].equals("-u")) {
            for (int i=0; i<articles.size(); i++) {
                if (!articles.get(i).equals("")) {
                    String s = articles.get(i).substring(0,8).trim();
                    if (s.equals(args[1])) {
                        index = i;
                        break;
                    }
                }
            }

            articles.remove(index);

            StringBuilder prodNameArgs = new StringBuilder();

            for (int i = 2; i < args.length-2; i++)
            {
                prodNameArgs.append(args[i] + " ");
            }

            String id = args[1];
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
            articles.add(index, id+productName+price+qty);
        }

        if (args[0].equals("-d")) {
            for (int i=0; i<articles.size(); i++) {
                if (!articles.get(i).equals("")) {
                    String s = articles.get(i).substring(0,8).trim();
                    if (s.equals(args[1])) {
                        index = i;
                        break;
                    }
                }
            }
            articles.remove(index);
        }

        for (String s:articles) {
            fileWrite.write(s + "\n");
        }

        fileWrite.flush();

        reader.close();
        fileWrite.close();
    }
}
