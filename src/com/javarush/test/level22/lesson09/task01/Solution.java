package com.javarush.test.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример, "мор"-"ром", "трос"-"сорт"
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file = new BufferedReader(new FileReader(reader.readLine()));

        List<String> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();

        while (file.ready()) {
            String s = file.readLine();
            int algPos = 0;

            for (int i = 0; i < s.length(); i++)
            {
                if (s.charAt(i) == ' ') {
                    list.add(s.substring(algPos, i).trim());
                    algPos = i;
                }
                else if (i == s.length()-1) {
                    list.add(s.substring(algPos).trim());
                    algPos = 0;
                }
            }
        }

        for (int i = 0; i < list.size(); i++)
        {
            for (int j = i+1; j < list.size(); j++)
            {
                StringBuilder sb = new StringBuilder(list.get(i));
                if (sb.reverse().toString().equals(list.get(j)) && !map.containsKey(list.get(j)) && !map.containsValue(list.get(j))) {
                    map.put(list.get(i), list.get(j));
                    break;
                }
            }
        }

        for (Map.Entry<String,String> pair:map.entrySet()) {
            System.out.println(pair.getKey() + "+" + pair.getValue());
            Pair pr = new Pair();
            pr.first = pair.getKey();
            pr.second = pair.getValue();
            result.add(pr);
        }

        for (Pair pair:result) {
            System.out.println(pair);
        }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
