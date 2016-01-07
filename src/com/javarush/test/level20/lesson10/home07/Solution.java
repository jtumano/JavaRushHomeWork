package com.javarush.test.level20.lesson10.home07;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать экземпляр класса Solution
2) записать в него данные  - writeObject
3) сериализовать класс Solution  - writeObject(ObjectOutputStream out)
4) десериализовать, получаем новый объект
5) записать в новый объект данные - writeObject
6) проверить, что в файле есть данные из п.2 и п.5
*/
public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;

    String fn;
    private static final long serialVersionUID = 1L;

    public Solution(String fileName) throws FileNotFoundException {
        fn = fileName;
        this.stream = new FileOutputStream(fn, true);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeObject(fn);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        fn = (String) in.readObject();
        stream = new FileOutputStream(fn, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception
    {
        FileOutputStream outputStream = new FileOutputStream("jan2");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);


        Solution solution = new Solution("jan");
        solution.writeObject("proba");
        solution.writeObject("probaa");

        solution.writeObject(objectOutputStream);

        outputStream.close();
        objectOutputStream.close();

        FileInputStream inputStream = new FileInputStream("jan2");
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        Solution solution1 = new Solution("jan3");
        solution1.readObject(objectInputStream);
        solution1.writeObject("proba1");
        solution1.writeObject("proba");
    }
}