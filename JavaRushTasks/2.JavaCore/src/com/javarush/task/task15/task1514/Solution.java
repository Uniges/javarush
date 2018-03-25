package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(5.5, "Первый");
        labels.put(8.9, "Второй");
        labels.put(10.3, "Третий");
        labels.put(7.7, "Четвертый");
        labels.put(12.3, "Пятый");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
