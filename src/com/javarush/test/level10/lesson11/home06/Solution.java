package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        //напишите тут ваши переменные и конструкторы
        private int age=1;
        private char sex= 'M';
        private int weight = 5;
        private int tall = 40;
        private String address = "Roddom";
        private String name = "undefined";
        Human(){
            System.out.print(age + sex + weight + tall + address + name);
        }
        Human(int age, char sex, int weight, int tall, String address, String name){
            this.age = age;
            this.sex = 'M';
            this.weight = 5;
            this.tall = 45;
            this.address = "U roditelei";
            this.name = "Vasja";
        }
        Human(String name){
            this.name = name;
            System.out.println(name);
        }
        Human(String name, String address){
            this.name = name;
            this.address = address;
            System.out.println("Menja zovut " + name + " ja zivu v " + address);
        }
        Human(int weight, int tall){
            this.weight = weight;
            this.tall = tall;
            System.out.println("Ves/rost " + weight + " " + tall);
        }
        Human(char sex, String name){
            this.sex = sex;
            this.name = name;
            System.out.print("Menja zovut " + name + ". Ja " + sex);
        }
        Human(char sex, String name, String address){
            this.sex = sex;
            this.name = name;
            this.address = address;
            System.out.println("Menja zovut " + name + ". Ja " + sex);
            System.out.println("Ja zivu v " + address);
        }
        Human(String name, char sex, int weight, int tall){
            this.weight = weight;
            this.sex = sex;
            this.name = name;
            this.tall = tall;
        }
        Human(String address, int weight){
            this.address = address;
            this.weight = weight;
            System.out.println("Prosto weight");
        }
        Human(char sex){
            if (sex == this.sex)
                System.out.println("true");
            else this.sex = sex;
        }
    }
}
