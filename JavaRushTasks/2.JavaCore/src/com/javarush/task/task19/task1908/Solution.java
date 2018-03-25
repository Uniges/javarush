package com.javarush.task.task19.task1908;

/* 
Выделяем числа
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
        String[] sArr = s.split(" ");
        String result = "";
        for (String ss : sArr) if (isInteger(ss)) result+=ss+" ";
        fileWriter.write(result.substring(0, result.length()-1));
        fileWriter.close();
    }
    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
