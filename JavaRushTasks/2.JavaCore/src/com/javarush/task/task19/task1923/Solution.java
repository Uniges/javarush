package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        FileWriter fileWriter = new FileWriter(args[1]);
        String s = "";
        while (fileReader.ready()) {
            s+=(char)fileReader.read();
        }
        fileReader.close();
        String[] lines = s.split("\\r?\\n");
        String[] linesResult;
        String resultLine = "";
        for (String ss : lines) {
            linesResult = ss.split(" ");
            in: for (String sss : linesResult) {
                char[] ch = sss.toCharArray();
                for (char chch : ch) {
                    if (Character.isDigit(chch)) {
                        resultLine += sss + " ";
                        continue in;
                    }
                }
            }
        }
        fileWriter.write(resultLine.substring(0, resultLine.length()-1));
        fileWriter.close();
    }
}
