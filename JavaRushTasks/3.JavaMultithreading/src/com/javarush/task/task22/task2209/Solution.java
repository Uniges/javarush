package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //...
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String name = bufferedReader.readLine();
        FileReader fileReader = new FileReader(name);
        String s = "";
        while (fileReader.ready()) s+=(char)fileReader.read();
        Set<String> set = new TreeSet<>();
        for (String str : s.split(" ")) set.add(str);
        String[] strArr = set.toArray(new String[set.size()]);
        /*for (String str : set) System.out.println(str);*/
        /*for (String str : strArr) System.out.println(str);*/

        StringBuilder result = getLine(strArr);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder str;
        String temp;
        in: for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                if (words[i].toLowerCase().charAt(words[i].length()-1) == words[j].toLowerCase().charAt(0)) {
                    temp = words[i+1];
                    words[i+1] = words[j];
                    words[j] = temp;
                    continue in;
                }
            }
        }
        String finalString = "";
        for (String s : words) finalString+=s+" ";
        str = new StringBuilder(finalString.trim());
        return str;
    }
}
