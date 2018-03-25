package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(name);
        if (fileInputStream.available() > 0) {
            byte[] buffer = new byte[fileInputStream.available()];
            int count = fileInputStream.read(buffer);
            String s = new String(buffer);
            String strArr[] = s.split("\\r?\\n");
            for (String ss : strArr) {
                String strArrSplit[] = ss.split(" ");
                if (strArrSplit[0].contains(String.valueOf(args[0]))) System.out.println(ss);
            }
        }
        fileInputStream.close();
    }
}
