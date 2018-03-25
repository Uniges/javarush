package com.javarush.task.task26.task2603;

import java.util.Comparator;

/*
Убежденному убеждать других не трудно
*/
public class Solution {

    //static Comparator<CustomizedComparator>()

    public static void main(String[] args) {

    }
}

class CustomizedComparator<T extends Comparable<T>> implements Comparator<T> {
    Comparator[] comparators;

    public int compare(T a, T b) {
        return a.compareTo(b);
    }
}
