package com.javarush.test.level19.lesson10.home09;

/* Контекстная реклама
В методе main подмените объект System.out написанной вами реадер-оберткой
Ваша реадер-обертка должна выводить на консоль контекстную рекламу после каждого второго println-а
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Рекламный текст: "JavaRush - курсы Java онлайн"

Пример вывода:
first
second
JavaRush - курсы Java онлайн
third
fourth
JavaRush - курсы Java онлайн
fifth
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        int i=0;
        int pos=0;
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
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < result.length(); j++)
        {
            if (i<1) {
                if (result.toCharArray()[j] == '\n') {
                    i++;
                }
            }
            else {
                if (result.toCharArray()[j] == '\n') {
                    sb.append(result.substring(0,j));
                    sb.append("\nJavaRush - курсы Java онлайн\n");
                    i=0;
                    pos=++j;
                    for (;j<result.length();j++) {
                        if (i<1) {
                            if (result.toCharArray()[j] == '\n') {
                                i++;
                            }
                        }
                        else {
                            if (result.toCharArray()[j] == '\n') {
                                sb.append(result.substring(pos,j));
                                sb.append("\nJavaRush - курсы Java онлайн\n");
                                i=0;
                                pos=++j;
                            }
                        }
                    }
                }
            }
        }
        sb.append(result.substring(pos));

        //Возвращаем все как было
        System.setOut(consoleStream);
        System.out.println(sb.toString());
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
