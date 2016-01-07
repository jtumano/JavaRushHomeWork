package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
Метод main не участвует в тестировании.
*/
public class Solution implements Serializable {
    public static class A {
        protected String name = "A";

        public A() {}

        public A(String name) {
            this.name += name;
        }
    }

    public class B extends A implements Serializable {
        public B(String name) {
            super(name);
            this.name += name;
        }

        private void writeObject(ObjectOutputStream out) throws IOException {
            out.defaultWriteObject();
            out.writeObject(name);
        }

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            in.defaultReadObject();

            name = (String) in.readObject();
        }
    }

    public static void main(String[] args) throws Exception
    {
        FileInputStream fileInputStream = new FileInputStream("jan");
        FileOutputStream fileOutputStream = new FileOutputStream("jan");

        ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
        ObjectInputStream ois = new ObjectInputStream(fileInputStream);

        Solution solution = new Solution();

        Solution.B before = solution.new B("B");

        System.out.println(before.name);

        oos.writeObject(before);

        B after = (B) ois.readObject();

        System.out.println(after.name);
    }
}
