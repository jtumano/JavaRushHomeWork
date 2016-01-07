package com.javarush.test.level05.lesson05.task05;

/* Провести три боя  попарно между котами
Создать три кота используя класс Cat.
Провести три боя попарно между котами.
Класс Cat создавать не надо. Для боя использовать метод boolean fight(Cat anotherCat).
Результат каждого боя вывести на экран.
*/
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
        System.out.println();

        System.out.println(nname + " vs. " + nname2 + ":");
        System.out.println();
        if (murzik.fight(vaska))
            System.out.println(nname + " wins");
        else System.out.println(nname2 + " wins");

        System.out.println();
        System.out.println();
        System.out.println(nname3 + " vs. " + nname + ":");
        if (barsik.fight(murzik))
            System.out.println(nname3 + " wins");
        else System.out.println(nname + " wins");

        System.out.println();
        System.out.println();
        System.out.println(nname2 + " vs. " + nname3 + ":ddka" +
                "");
        if (vaska.fight(barsik))
            System.out.println(nname2 + " wins");
        else System.out.println(nname3 + " wins");
    }

    public static class Cat {

        public static int count = 0;
        public static int fightCount = 0;

        protected String name;
        protected int age;
        protected int weight;
        protected int strength;

        public Cat(String name, int age, int weight, int strength) {
            count++;

            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }

        public boolean fight(Cat anotherCat) {
            fightCount++;

            int agePlus = this.age > anotherCat.age ? 1 : 0;
            int weightPlus = this.weight > anotherCat.weight ? 1 : 0;
            int strengthPlus = this.strength > anotherCat.strength ? 1 : 0;

            int score = agePlus + weightPlus + strengthPlus;
            return score > 2; // return score > 2 ? true : false;
        }
    }
}
