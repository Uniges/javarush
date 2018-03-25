package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        FileInputStream inputStream = new FileInputStream(s1);
        FileOutputStream outputStream = new FileOutputStream(s2);
        if (inputStream.available() > 0) {
            byte[] buffer = new byte[inputStream.available()];
            int countOne = inputStream.read(buffer);
            for (int i = 0; i < buffer.length / 2; i++) {
                byte tmp = buffer[i];
                buffer[i] = buffer[buffer.length - i - 1];
                buffer[buffer.length - i - 1] = tmp;
            }
            outputStream.write(buffer, 0, countOne);
        }
        inputStream.close();
        outputStream.close();
    }
}
