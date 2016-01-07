package com.javarush.test.level05.lesson12.home02;

/* Man and Woman
1. Внутри класса Solution создай public static классы Man и Woman.
2. У классов должны быть поля: name(String), age(int), address(String).
3. Создай конструкторы, в которые передаются все возможные параметры.
4. Создай по два объекта каждого класса со всеми данными используя конструктор.
5. Объекты выведи на экран в таком формате [name + " " + age + " " + address].
*/

public class Solution
{
    public static void main(String[] args)
    {
        //создай по два объекта каждого класса тут
        Man man1 = new Man("mAn1", 15, "Pomoika9");
        Man man2 = new Man("mAn2", 19, "Pomoika19");
        Woman woman1 = new Woman("wOman1", 15, "Pomojka9");
        Woman woman2 = new Woman("wOman2", 19, "Pomojka19");
        //выведи их на экран тут
    }

    //добавьте тут ваши классы
    public static class Man
    {
        public String name = null;
        public int age;
        public String address = null;

        Man(String name, int age, String address){
            this.name = name;
            this.age = age;
            this.address = address;
            System.out.println(name + " " + age + " " + address);
        }
        Man(String name, int age){
            this.name = name;
            this.age = age;
        }
    }
    public static class Woman
    {
        String name = null;
        int age;
        String address = null;

        Woman(String name, int age, String address){
            this.name = name;
            this.age = age;
            this.address = address;
            System.out.println(this.name + " " + this.age + " " + this.address);
        }
        Woman(String name, int age){
            this.name = name;
            this.age = age;
        }
    }
}
