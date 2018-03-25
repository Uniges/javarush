package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name;
        while(!(name=reader.readLine()).equals("exit")) {
            ReadThread readThread = new ReadThread(name);
            readThread.start();
        }
    }

    public static class ReadThread extends Thread {
        String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            try {
                FileInputStream fileInputStream = new FileInputStream(fileName);
                if (fileInputStream.available() > 0) {
                    byte[] buffer = new byte[fileInputStream.available()];
                    int count = fileInputStream.read(buffer);
                    int resultByte = 0;
                    int resultInteger = 0;
                    for (byte a : buffer) {
                        int result = 0;
                        for (byte b : buffer) {
                            if (a == b) result++;
                        }
                        if (result > resultInteger) {
                            resultInteger = result;
                            resultByte = a;
                        }
                    }
                    resultMap.put(fileName, resultByte);
                }
                fileInputStream.close();
            } catch (IOException e) {
            }
        }
    }
}
