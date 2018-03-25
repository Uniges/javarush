package com.javarush.task.task19.task1925;

/* 
Длинные слова
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
        String result = "";
        for (String ss : lines) {
            linesResult = ss.split(" ");
            for (String sss : linesResult) if (sss.length()>6) result+=sss+",";
        }
        fileWriter.write(result.substring(0, result.length()-1));
        fileWriter.close();
    }
}
