package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    public static void main(String[] args) throws InterruptedException {
        Horse horse1 = new Horse("John", 3, 0);
        Horse horse2 = new Horse("James", 3, 0);
        Horse horse3 = new Horse("Fred", 3, 0);
        List<Horse> horseList = new ArrayList<>();
        horseList.add(horse1);
        horseList.add(horse2);
        horseList.add(horse3);
        Hippodrome hippodrome = new Hippodrome(horseList);
        game = hippodrome;
        game.run();
        //System.out.println(game.getHorses());
        game.printWinner();
    }

    static Hippodrome game;
    private List<Horse> horses = new ArrayList<>();

    public Hippodrome(List horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return this.horses;
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }
    public void move() {
        for (Horse horse : this.horses) {
            horse.move();
        }
    }
    public void print() {
        for (Horse horse : this.horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) System.out.println();
    }

    public Horse getWinner() {
        double max = 0;
        Horse horseWinner = null;
        for (Horse horse : this.horses) {
            if (horse.distance > max) {
                max = horse.distance;
                horseWinner = horse;
            }
        }
        return horseWinner;
    }
    public void printWinner() {
        System.out.println("Winner is "+getWinner().name+"!");
    }
}
