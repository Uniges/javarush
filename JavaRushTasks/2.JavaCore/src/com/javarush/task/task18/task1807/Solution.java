package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());

        if (inputStream.available() > 0) {
            int result = 0;
            byte[] buffer = new byte[inputStream.available()];
            int count = inputStream.read(buffer);
            for (byte b : buffer) {
                if (b == ',') result++;
            }
            System.out.print(result);
        }
        inputStream.close();
    }
}
