package com.javarush.task.task18.task1801;

import java.io.FileInputStream;
import java.util.Scanner;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        FileInputStream inputStream = new FileInputStream(name);
        int result = 0;
        while (inputStream.available() > 0) {
            int data = inputStream.read();
            if (data > result) result = data;
        }
        inputStream.close();
        System.out.println(result);
    }
}
