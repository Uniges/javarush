package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String s3 = sc.nextLine();
        FileInputStream inputStream = new FileInputStream(s1);
        FileOutputStream outputStreamOne = new FileOutputStream(s2);
        FileOutputStream outputStreamTwo = new FileOutputStream(s3);

        int firstPart = 0;
        int secondPart = 0;
        if (inputStream.available() % 2 == 0) {
            firstPart = inputStream.available() / 2;
            secondPart = firstPart;
        } else if (inputStream.available() != 0) {
            secondPart = inputStream.available() / 2;
            firstPart = secondPart + 1;
        }
        if (inputStream.available() > 0) {
            byte[] bufferOne = new byte[firstPart];
            byte[] bufferTwo = new byte[secondPart];
            int countOne = inputStream.read(bufferOne);
            int countTwo = inputStream.read(bufferTwo);
            outputStreamOne.write(bufferOne, 0, countOne);
            outputStreamTwo.write(bufferTwo, 0, countTwo);
        }
        inputStream.close();
        outputStreamOne.close();
        outputStreamTwo.close();
    }
}
