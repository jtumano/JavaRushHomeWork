package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
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

        String recordName = "";
        Double recordValue = 0.0;

        for (Map.Entry<String, Double> pair : map.entrySet()) {
            if (pair.getValue() > recordValue) {
                recordValue = pair.getValue();
                recordName = pair.getKey();
            }
        }

        System.out.println(recordName);

        for (Map.Entry<String, Double> pair : map.entrySet()) {
            if (pair.getValue() == recordValue && pair.getKey() != recordName) {
                System.out.println(recordName);
            }
        }

        file.close();
    }
}
