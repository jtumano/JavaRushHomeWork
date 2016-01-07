package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        //запоминаем настоящий PrintStream в специальную переменную
        PrintStream consoleStream = System.out;

        //Создаем динамический массив
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //создаем адаптер к классу PrintStream
        PrintStream stream = new PrintStream(outputStream);
        //Устанавливаем его как текущий System.out
        System.setOut(stream);

        //Вызываем функцию, которая ничего не знает о наших манипуляциях
        testString.printSomething();

        //Преобразовываем записанные в наш ByteArray данные в строку
        String result = outputStream.toString();

        List<String> list = new ArrayList<>();
        int answer=0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < result.length(); i++)
        {
            if (result.toCharArray()[i] == ' ') {
                list.add(result.substring(0, i));

                int pos = i++;
                for (; i<result.length(); i++) {
                    if (result.toCharArray()[i] == ' ') {
                        list.add(result.substring(pos+1,i));
                        pos = i++;
                        for (; i<result.length(); i++) {
                            if (result.toCharArray()[i] == ' ') {
                                list.add(result.substring(pos+1,i));
                                pos = i++;
                                for (; i<result.length(); i++) {
                                    if (result.toCharArray()[i] == ' ') {
                                        list.add(result.substring(pos+1,i));
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                        break;
                    }
                }
                break;
            }
        }

        if (list.get(1).contains("+")) {
            answer = Integer.parseInt(list.get(0)) + Integer.parseInt(list.get(2));
            sb.append(result.substring(0, result.length()-1));
            sb.append(answer);
        }
        else if (list.get(1).contains("-")) {
            answer = Integer.parseInt(list.get(0)) - Integer.parseInt(list.get(2));
            sb.append(result.substring(0, result.length()-1));
            sb.append(answer);
        }
        else if (list.get(1).contains("*")) {
            answer = Integer.parseInt(list.get(0)) * Integer.parseInt(list.get(2));
            sb.append(result.substring(0, result.length()-1));
            sb.append(answer);
        }

        //Возвращаем все как было
        System.setOut(consoleStream);
        System.out.print(sb.toString());
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

