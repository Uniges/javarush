package com.javarush.task.task26.task2601;

import java.util.*;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
        /*Integer[] example = {-1, -2, 3, 2, 8, 5};
        for (int i : sort(example)) {
            System.out.print(i+" ");
        }*/
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here

        Arrays.sort(array);

        /*for (int i : array) {
            System.out.print(i+" ");
        }

        System.out.println(" - отсортированный по возрастанию массив!");*/


        int median;
        if (array.length%2==0) {
            median = (array[array.length/2]+array[(array.length/2)-1])/2;
            System.out.println(median+" - медиана.");
        }
        else {
            median = array[array.length/2];
            System.out.println(median+" - медиана.");
        }


        int iTemp;
        //int jTemp;
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (Math.abs(median-array[i]) > Math.abs(median-array[j])) {
                    iTemp = array[i];
                    array[i] = array[j];
                    array[j] = iTemp;
                }
                /*else if (Math.abs(median-array[i]) < Math.abs(median-array[j])) {
                    jTemp = array[j];
                    array[j] = array[i];
                    array[i] = jTemp;
                }*/
                else if (Math.abs(median-array[i]) == Math.abs(median-array[j])) {
                    if (array[i] > array[j]) {
                        iTemp = array[i];
                        array[i] = array[j];
                        array[j] = iTemp;
                    }
                }
            }
        }

        /*Arrays.sort(array);

        for (int i : array) {
            System.out.print(i+" ");
        }

        System.out.println(" - отсортированный по возрастанию массив!");

        int median = 0;
        if (array.length%2==0) {
            //System.out.println(array[array.length/2]);
            //System.out.println(array[(array.length/2)-1]);
            median = (array[array.length/2]+array[(array.length/2)-1])/2;
            System.out.println(median+" - медиана.");
        }
        else {
            median = array[array.length/2];
            System.out.println(median+" - медиана.");
        }


        //System.out.println(median);

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            map.put(Math.abs(median-array[i]), (array[i]));
        }

        Integer finalArray[] = new Integer[array.length];

        int i = 0;
        for(Map.Entry e : map.entrySet()){
            System.out.println(e.getKey()+" "+ e.getValue());
            finalArray[i] = (int)e.getValue();
            i++;
        }

        return finalArray;*/
        return array;
    }
}
