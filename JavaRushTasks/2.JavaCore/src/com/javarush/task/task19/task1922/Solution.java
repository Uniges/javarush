package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String name = bufferedReader.readLine();
        bufferedReader.close();
        FileReader fileReader = new FileReader(name);
        String s = "";
        while (fileReader.ready()) {
            s+=(char)fileReader.read();
        }
        fileReader.close();
        String[] lines = s.split("\\r?\\n");
        String[] linesResult;
        int i = 0;
        for (String ss : lines) {
            linesResult = ss.split(" ");
            for (String sss : linesResult) {
                for (String word : words) {
                    if (word.equals(sss)) i++;
                }
            }
            if (i == 2) System.out.println(ss);
            i = 0;
        }
    }
}
