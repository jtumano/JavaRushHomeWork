package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось:
Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Human ded1 = new Human("Ded1", true, 68);
        Human ded2 = new Human("Ded2", true, 65);
        Human babka1 = new Human("Babka1", false, 63);
        Human babka2 = new Human("Babka2", false, 64);
        Human otec = new Human("Otec", true, 35, ded1, babka1);
        Human mat = new Human("Matj", false, 34, ded2, babka2);
        Human child1 = new Human("Vasja", true, 10, otec, mat);
        Human child2 = new Human("Petka", true, 9, otec, mat);
        Human child3 = new Human("Mashka", false, 5, otec, mat);
    }

    public static class Human
    {
        //напишите тут ваш код
        String name;
        Boolean sex;
        int age;
        Human father = null;
        Human mother = null;

        Human(String name, Boolean gender, int age, Human father, Human mother)
        {
            this.name = name;
            this.sex = gender;
            this.age = age;
            this.father = father;
            this.mother = mother;
            System.out.println(toString());
        }

        Human(String name, Boolean gender, int age)
        {
            this.name = name;
            this.sex = gender;
            this.age = age;
            System.out.println(toString());
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
