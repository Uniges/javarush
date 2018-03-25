package com.javarush.task.task18.task1804;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> allByte = new ArrayList<Integer>();
        ArrayList<Integer> resultByte = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        FileInputStream iS1 = new FileInputStream(name);
        int size = iS1.available();

        int length = 0;
        int result = 128;
        for (int i = 0; i < size; i++) {
            int data1 = iS1.read();
            if (i == 0) {
                FileInputStream iS2 = new FileInputStream(name);
                while (iS2.available() > 0) {
                    int data2 = iS2.read();
                    allByte.add(data2);
                }
                iS2.close();
            }
            for (Integer j : allByte) {
                if (j == data1) {
                    length++;
                }
            }
            if (length < result) {
                result = length;
            }
            length = 0;
            if (i == size-1) {
                for (Integer j : allByte) {
                    for (Integer k : allByte) {
                        if (j == k) {
                            length++;
                        }
                    }
                    if (length == result) {
                        resultByte.add(j);
                    }
                    length = 0;
                }
                HashSet<Integer> resultKey = new HashSet<Integer>(resultByte);
                for (Integer k : resultKey) {
                    System.out.print(k + " ");
                }
            }
        }
        iS1.close();
    }
}
