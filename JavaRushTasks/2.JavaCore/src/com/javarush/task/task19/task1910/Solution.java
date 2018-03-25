package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String nameOne = bufferedReader.readLine();
        String nameTwo = bufferedReader.readLine();
        bufferedReader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(nameOne));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(nameTwo));

        String s = "";
        while (fileReader.ready()) {
            char ch = (char)fileReader.read();
            if (Character.isAlphabetic(ch) || Character.isDigit(ch)) {
                fileWriter.write(ch);
            }
        }
        fileReader.close();
        fileWriter.close();
    }
}
