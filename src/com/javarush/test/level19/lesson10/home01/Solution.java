package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader file = new BufferedReader(new FileReader(args[0]));

        Map<String, Double> map = new TreeMap<>();

        while (file.ready()) {
            String s = file.readLine();

            for (int i=0; i<s.toCharArray().length; i++) {
                if (s.toCharArray()[i] == 32) {
                    if (map.containsKey(s.substring(0,i))) {
                        map.put(s.substring(0,i), map.get(s.substring(0,i))+Double.parseDouble(s.substring(++i)));
                    }
                    else map.put(s.substring(0,i), Double.parseDouble(s.substring(++i)));
                }
            }
        }

        for (Map.Entry<String, Double> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }

        file.close();
    }
}
