package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        if (fileInputStream.available() > 0) {
            byte[] buffer = new byte[fileInputStream.available()];
            int count = fileInputStream.read(buffer);
            Map<Character, Integer> map = new TreeMap<>();
            for (byte b : buffer) {
                int result = 0;
                for (byte c : buffer) {
                    if (b==c) {
                        result++;
                    }
                }
                map.put((char)b, result);
            }
            for (Map.Entry entry : map.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
        fileInputStream.close();

    }

}
