package com.javarush.task.task19.task1909;

/* 
Замена знаков
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
            s+=(char)fileReader.read();
        }
        fileReader.close();

        fileWriter.write(s.replaceAll("[.]","!"));
        fileWriter.close();
    }
}
