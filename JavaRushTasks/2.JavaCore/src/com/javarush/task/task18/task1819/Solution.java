package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        FileInputStream fileInput1 = new FileInputStream(s1);
        byte[] buffer1 = null;
        if (fileInput1.available() > 0) {
            buffer1 = new byte[fileInput1.available()];
            int count1 = fileInput1.read(buffer1);
        }
        fileInput1.close();
        FileOutputStream fileOutput1 = new FileOutputStream(s1);
        FileInputStream fileInput2 = new FileInputStream(s2);
        if (fileInput2.available() > 0) {
            byte[] buffer2 = new byte[fileInput2.available()];
            int count2 = fileInput2.read(buffer2);
            fileOutput1.write(buffer2);
            fileOutput1.write(buffer1);
        }
        fileInput2.close();
        fileOutput1.close();
    }
}
