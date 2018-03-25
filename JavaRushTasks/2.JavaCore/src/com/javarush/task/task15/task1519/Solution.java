package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = reader.readLine();
            if (s.equals("exit")) break;
            if (isInteger(s)) {
                int j = Integer.parseInt(s);
                if (j > 0 && j < 128) {
                    short sh = (short) j;
                    print(sh);
                }
                else if (j <= 0 || j >= 128) print(j);
            }
            else if (isDouble(s)) {
                double d = Double.parseDouble(s);
                print(d);
            }
            else print(s);
        }

    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    public static boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}