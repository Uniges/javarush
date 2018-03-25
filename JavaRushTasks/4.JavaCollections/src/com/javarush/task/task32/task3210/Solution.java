package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        /*String fileName = args[0];
        String number = args[1];
        String text = args[2];

        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");

        long fileSize = raf.length();
        long bytePosition = Long.parseLong(number);

        raf.seek(bytePosition);
        String readString = raf.readLine();

        raf.seek(fileSize);
        if (readString.equals(text)) {
            raf.writeBytes("true");
        }
        else {
            raf.writeBytes("false");
        }*/
        String fileName = args[0];
        String number = args[1];
        String text = args[2];

        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");

        long fileSize = raf.length();
        long bytePosition = Long.parseLong(number);
        int textLength = text.length();

        raf.seek(bytePosition);
        //1 символ - 2 байта... Почему тогда побайтный массив длины не "длинна текста * 2" - разобраться позже!
        byte[] b = new byte[textLength];
        raf.read(b, 0, textLength);

        String string = new String(b);

        raf.seek(fileSize);
        if (string.equals(text)) {
            raf.write("true".getBytes());
        }
        else {
            raf.write("false".getBytes());
        }
    }
}
