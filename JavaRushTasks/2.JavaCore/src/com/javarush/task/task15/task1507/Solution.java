package com.javarush.task.task15.task1507;

/* 
ООП - Перегрузка
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    public static void printMatrix(String s) {
    }

    public static void printMatrix(String s, double d) {
    }

    public static void printMatrix(String s, double d, char ch) {
    }

    public static void printMatrix(double d, String s) {
    }

    public static void printMatrix(char ch, double d, String s) {
    }

    public static void printMatrix(boolean b, int i) {
    }

    public static void printMatrix(boolean b, String s1, String s2) {
    }

    public static void printMatrix(String s1, String s2) {
    }
}
