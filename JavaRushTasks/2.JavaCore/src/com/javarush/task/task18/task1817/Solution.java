package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        int sumChar = 0;
        int sumSpace = 0;

        if (inputStream.available() > 0) {
            byte[] buffer = new byte[inputStream.available()];
            int count = inputStream.read(buffer);
            for (byte b : buffer) {
                if (b == ' ') sumSpace++;
            }
            sumChar = buffer.length;
        }
        inputStream.close();
        System.out.println(String.format(Locale.ENGLISH, "%(.2f", ((double)sumSpace/(double)sumChar*100)));
    }
}
