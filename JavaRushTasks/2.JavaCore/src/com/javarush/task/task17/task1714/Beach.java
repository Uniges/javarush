package com.javarush.task.task17.task1714;

/* 
Comparable
*/

public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {
        Beach b1 = new Beach("Beach1", 4, 10);
        Beach b2 = new Beach("Beach2", 5, 4);
        System.out.print(b1.compareTo(b2));
    }

    @Override
    public synchronized int compareTo(Beach o) {
        int result = 0;
        if (distance < o.distance) result++;
        if (distance > o.distance) result-=1;
        if (quality > o.quality) result++;
        if (quality < o.quality) result-=1;
        return result;
    }
}
