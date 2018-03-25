package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String name = null;
            try {
                name = reader.readLine();
                FileInputStream fileInputStream = new FileInputStream(name);
                fileInputStream.close();
            } catch (FileNotFoundException e) {
                System.out.println(name);
                break;
            } catch (IOException e) {
            }
        }

    }
}
