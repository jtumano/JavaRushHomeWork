package com.javarush.test.level17.lesson10.bonus01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException{
        //start here - начни тут
        if (args[0].equals("-c")) {
            if (args.length == 4) {
                createEntry(args[1], args[2], args[3]);
            }
            else if (args.length == 5) {
                createLongEntry(args[1], args[2], args[3], args[4]);
            }
        }
        else if (args[0].equals("-u")) {
            if (args.length == 5) {
                updateEntry(args[1], args[2], args[3], args[4]);
            }
            if (args.length == 6) {
                updateLongEntry(args[1], args[2], args[3], args[4], args[5]);
            }
        }
        else if (args[0].equals("-d")) {
            if (args.length == 2) {
                deleteLogEntry(args[1]);
            }
        }
        else if (args[0].equals("-i")) {
            if (args.length == 2) {
                infoEntry(args[1]);
            }
        }
    }

    private static void createEntry(String name, String sex, String bd) throws ParseException{
        Person person = null;

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date date = df.parse(bd);

        if (sex.equals("м")) person = Person.createMale(name, date);
        else if (sex.equals("ж")) person = Person.createFemale(name, date);

        allPeople.add(person);

        System.out.println(allPeople.indexOf(person));
    }

    private static void createLongEntry(String name, String name2, String sex, String bd) throws ParseException{
        Person person = null;

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date date = df.parse(bd);

        String wname = name + " " + name2;

        if (sex.equals("м")) person = Person.createMale(wname, date);
        else if (sex.equals("ж")) person = Person.createFemale(wname, date);

        allPeople.add(person);

        System.out.println(allPeople.indexOf(person));
    }

    private static void updateEntry(String id, String name, String sex, String bd) throws ParseException{
        Person person = allPeople.get(Integer.parseInt(id));

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date date = df.parse(bd);

        person.setName(name);
        if (sex.equals("м")) person.setSex(Sex.MALE);
        else if (sex.equals("ж")) person.setSex(Sex.FEMALE);
        person.setBirthDay(date);

        allPeople.set(Integer.parseInt(id), person);
    }

    private static void updateLongEntry(String id, String name, String name2, String sex, String bd) throws ParseException{
        Person person = allPeople.get(Integer.parseInt(id));

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date date = df.parse(bd);

        String wname = name + " " + name2;

        person.setName(wname);
        if (sex.equals("м")) person.setSex(Sex.MALE);
        else if (sex.equals("ж")) person.setSex(Sex.FEMALE);
        person.setBirthDay(date);

        allPeople.set(Integer.parseInt(id), person);
    }

    private static void deleteLogEntry(String id) {
        Person person = allPeople.get(Integer.parseInt(id));

        person.setName(null);
        person.setSex(null);
        person.setBirthDay(null);

        allPeople.set(Integer.parseInt(id), person);
    }

    private static void infoEntry(String id) {
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        Person person = allPeople.get(Integer.parseInt(id));

        String ch = "";

        if (person.getSex().equals(Sex.MALE)) ch = "м";
        else if (person.getSex().equals(Sex.FEMALE)) ch = "ж";

        System.out.println(person.getName() + " " + ch + " " + df.format(person.getBirthDay()));
    }
}
