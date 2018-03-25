package com.javarush.task.task18.task1813;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "C:/tmp/result.txt";

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

    FileOutputStream fileOutputStream;
    public AmigoOutputStream(FileOutputStream fileOutputStream) throws FileNotFoundException {
        super(fileName);
        this.fileOutputStream = fileOutputStream;
    }

    public void flush() throws IOException {
        fileOutputStream.flush();
    }

    public void write(int b) throws IOException {
        fileOutputStream.write(b);
    }

    public void write(byte[] b) throws IOException {
        fileOutputStream.write(b);
    }

    public void write(byte[] b, int off, int len) throws IOException {
        fileOutputStream.write(b, off, len);
    }

    public void close() throws IOException {
        fileOutputStream.flush();
        String text = "JavaRush © All rights reserved.";
        byte[] b = text.getBytes();
        fileOutputStream.write(b);
        fileOutputStream.close();
    }
}
