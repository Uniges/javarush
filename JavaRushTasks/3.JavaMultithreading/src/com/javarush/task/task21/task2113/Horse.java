package com.javarush.task.task21.task2113;

public class Horse {
    String name;
    double speed;
    double distance;

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void move() {
        this.distance += speed * Math.random();
    }

    public void print() {
        String result = "";
        int count;
        count = (int) Math.floor(this.distance);
        for (int i = 0; i < count; i++) result+=".";
        System.out.println(result+this.name);
    }

    public static void main(String[] args) {

    }
}
