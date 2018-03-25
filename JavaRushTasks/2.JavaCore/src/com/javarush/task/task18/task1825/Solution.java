package com.javarush.task.task18.task1825;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static Map<String, byte[]> resultMap = new TreeMap<String, byte[]>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name;
        String nameInput = null;
        while(!(name = reader.readLine()).equals("end")) {
            FileInputStream fileInputStream = new FileInputStream(name);
            if (fileInputStream.available()>0) {
                byte[] buffer = new byte[fileInputStream.available()];
                int count = fileInputStream.read(buffer);
                resultMap.put(name, buffer);
            }
            fileInputStream.close();
            nameInput = name;
        }
        for(Map.Entry<String,byte[]> entry : resultMap.entrySet()) {
            String key = entry.getKey();
            byte[] value = entry.getValue();
            System.out.println(key + " => " + value);
        }
        String[] nameOutput = nameInput.split(".part");
        FileOutputStream fileOutputStream = new FileOutputStream("D:/3.mp3");
        for(Map.Entry<String,byte[]> entry : resultMap.entrySet()) {
            byte[] value = entry.getValue();
            fileOutputStream.write(value);
        }
        fileOutputStream.close();
    }
}
