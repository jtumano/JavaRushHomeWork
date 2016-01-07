package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        InputStream inputStream = new FileInputStream(args[0]);

        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();

        while (inputStream.available() > 0) {
            list.add(inputStream.read());
        }

        for (Integer i : list) {
            if (map.containsKey(i)) {
                for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
                    if (pair.getKey() == i) {
                        map.put(pair.getKey(), pair.getValue()+1);
                    }
                }
            }
            else {
                map.put(i, 1);
            }
        }

        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            int a = pair.getKey();
            char ch = (char) a;
            System.out.print(ch + " " + pair.getValue() + "\n");
        }

        inputStream.close();
    }
}
