package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        String key = args[0];
        String fileName = args[1];
        String fileOutputName = args[2];
        FileInputStream fileInputStream = new FileInputStream(fileName);
        FileOutputStream fileOutputStream = new FileOutputStream(fileOutputName);
        if (key == "-e") {
            if (fileInputStream.available() > 0) {
                byte[] buffer = new byte[fileInputStream.available()];
                int count = fileInputStream.read(buffer);
                for (int i = 0; i < buffer.length; i++) {
                    buffer[i]+=1;
                }
                fileInputStream.close();
                fileOutputStream.write(buffer);
                fileOutputStream.close();
            }
        }
        else if (key == "-d") {
            if (fileInputStream.available() > 0) {
                byte[] buffer = new byte[fileInputStream.available()];
                int count = fileInputStream.read(buffer);
                for (int i = 0; i < buffer.length; i++) {
                    buffer[i]-=1;
                }
                fileInputStream.close();
                fileOutputStream.write(buffer);
                fileOutputStream.close();
            }
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
