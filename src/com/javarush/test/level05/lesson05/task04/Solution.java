package com.javarush.test.level05.lesson05.task04;

/* Создать три объекта типа Cat
В методе main создать три объекта типа Cat и заполнить их данными.
Использовать класс Cat из первой задачи. Класс Cat создавать не надо.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        //напишите тут ваш код

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Vvedite imja pervogo kota");
        String nname = reader.readLine();
        System.out.println("Vvedite vozrast pervogo kota");
        String aage = reader.readLine();
        System.out.println("Vvedite ves pervogo kota");
        String wweight = reader.readLine();
        System.out.println("Vvedite silu pervogo kota");
        String sstrenght = reader.readLine();

        System.out.println("Vvedite imja vtorogo kota");
        String nname2 = reader.readLine();
        System.out.println("Vvedite vozrast vtorogo kota");
        String aage2 = reader.readLine();
        System.out.println("Vvedite ves vtorogo kota");
        String wweight2 = reader.readLine();
        System.out.println("Vvedite silu vtorogo kota");
        String sstrenght2 = reader.readLine();

        System.out.println("Vvedite imja tretjego kota");
        String nname3 = reader.readLine();
        System.out.println("Vvedite vozrast tretjego kota");
        String aage3 = reader.readLine();
        System.out.println("Vvedite ves tretjego kota");
        String wweight3 = reader.readLine();
        System.out.println("Vvedite silu tretjego kota");
        String sstrenght3 = reader.readLine();

        int age = Integer.parseInt(aage);
        int age2 = Integer.parseInt(aage2);
        int age3 = Integer.parseInt(aage3);
        int weight = Integer.parseInt(wweight);
        int weight2 = Integer.parseInt(wweight2);
        int weight3 = Integer.parseInt(wweight3);
        int strength = Integer.parseInt(sstrenght);
        int strength2 = Integer.parseInt(sstrenght2);
        int strength3 = Integer.parseInt(sstrenght3);

        Cat murzik = new Cat(nname, age, weight, strength);
        Cat vaska = new Cat(nname2, age2, weight2, strength2);
        Cat barsik = new Cat(nname3, age3, weight3, strength3);


        System.out.println("The fight starts!");
        System.out.println("The fight starts!");
        System.out.println("The fight starts!");
    }

    public static class Cat {

        public static int count = 0;
        private String name;
        private int age;
        private int weight;
        private int strength;

        public Cat(String name, int age, int weight, int strength) {
            count++;

            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }
    }
}
