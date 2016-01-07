package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by jan on 26.10.15.
 */
public class Hippodrome
{
    private ArrayList<Horse> horses = new ArrayList<>();
    public static Hippodrome game;

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public void run() throws InterruptedException{
        for (int i = 1; i <= 100; i++)
        {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move() {
        for (Horse horse:horses) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse:horses) {
            horse.print();
        }
        System.out.println();
        System.out.println();
    }

    public Horse getWinner() {
        double distance = 0;
        int horsenr = 0;
        for (int i=0; i<horses.size(); i++) {
            if (horses.get(i).getDistance() > distance) {
                distance = horses.get(i).getDistance();
                horsenr = i;
            }
        }
        return horses.get(horsenr);
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName()+"!");
    }

    public static void main(String[] args) throws InterruptedException
    {
        game = new Hippodrome();

        Horse horse1 = new Horse("Lucky", 3, 0);
        Horse horse2 = new Horse("Biver", 3, 0);
        Horse horse3 = new Horse("Truny", 3, 0);

        game.getHorses().add(horse1);
        game.getHorses().add(horse2);
        game.getHorses().add(horse3);

        game.run();
        game.printWinner();
    }
}
