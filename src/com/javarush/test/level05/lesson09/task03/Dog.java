package com.javarush.test.level05.lesson09.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя конструкторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog
{
    //напишите тут ваш код
    private String name = null;
    private int pikkus;
    private String color = null;

    Dog(String name){
        this.name = name;
    }
    Dog(String name, int pikkus){
        this.name = name;
        this.pikkus = pikkus;
    }
    Dog(String name, int pikkus, String color){
        this.name = name;
        this.pikkus = pikkus;
        this.color = color;
    }
}
