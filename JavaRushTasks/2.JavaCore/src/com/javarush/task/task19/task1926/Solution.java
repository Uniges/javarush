package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
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
        for (int k = 0; k < lines.length; k++) {
            linesResult = lines[k].split(" ");
            for (int j = linesResult.length-1; j >= 0; j--) {
                char[] ch = linesResult[j].toCharArray();
                for (int i = ch.length-1; i >= 0; i--) {
                    System.out.print(ch[i]);
                }
                if (j!=0) System.out.print(" ");
            }
            if (k!=lines.length-1) System.out.println();
        }
    }
}
