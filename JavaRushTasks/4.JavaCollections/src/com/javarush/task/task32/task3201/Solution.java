package com.javarush.task.task32.task3201;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Paths;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) throws IOException {
        /*String fileName = args[0];
        String number = args[1];
        String text = args[2];

        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
        //Размер файла.
        long fileSize = Files.size(Paths.get(args[0]));
        //Размер вставляемой строки
        long textSize = text.length()*2;
        //Позиция в файле
        long bytePosition = Long.parseLong(number);

        if (fileSize-bytePosition >= textSize) {
            raf.seek(bytePosition);
            raf.writeBytes(text);
        }
        else {
            raf.seek(fileSize);
            raf.writeBytes(text);
        }*/

        String fileName = args[0];
        String number = args[1];
        String text = args[2];

        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");

        long fileSize = raf.length();
        long bytePosition = Long.parseLong(number);

        if (fileSize > bytePosition) {
            raf.seek(bytePosition);
        }
        else {
            raf.seek(fileSize);
        }
        raf.write(text.getBytes());
    }
}
