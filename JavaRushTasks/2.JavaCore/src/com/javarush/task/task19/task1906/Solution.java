package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String nameOne = bufferedReader.readLine();
        String nameTwo = bufferedReader.readLine();
        bufferedReader.close();
        FileReader fileReader = new FileReader(nameOne);
        FileWriter fileWriter = new FileWriter(nameTwo);
        while (fileReader.ready()) {
            Integer data = null;
            for (int i = 0; i < 2; i++) {
                data = fileReader.read();
            }
            fileWriter.write(data);
        }
        fileReader.close();
        fileWriter.close();
    }
}
