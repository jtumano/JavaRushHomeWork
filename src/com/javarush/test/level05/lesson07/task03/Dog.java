package com.javarush.test.level05.lesson07.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя инициализаторами:
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

    public void initialize(String name){
        this.name = name;
    }
    public void initialize(String name, int pikkus){
        this.name = name;
        this.pikkus = pikkus;
    }
    public void initialize(String name, int pikkus, String color){
        this.name = name;
        this.pikkus = pikkus;
        this.color = color;
    }
}
