package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameOne = reader.readLine();
        String nameTwo = reader.readLine();
        allLines = Files.readAllLines(Paths.get("D:/Java/"+nameOne+".txt"), StandardCharsets.UTF_8);
        forRemoveLines = Files.readAllLines(Paths.get("D:/Java/"+nameTwo+".txt"), StandardCharsets.UTF_8);
        joinData(allLines, forRemoveLines);
    }

    public static void joinData(List<String> a, List<String> b) throws CorruptedDataException {
        int i = 0;
        for (String s1 : a){
            for (String s2 : b) {
                if (s1.equals(s2)) i++;
            }
        }
        System.out.println("Вывод первого файла:");
        for (String line : a) System.out.println(line);
        System.out.println("Вывод второго файла:");
        for (String line : b) System.out.println(line);
        System.out.println();
        System.out.println("Количество эквивалентных строк - " + i);

        if (i == b.size()) {
            for (int j = 0; j < a.size(); j++) {
                for (int k = 0; k < b.size(); k++) {
                    if (a.get(j).equals(b.get(k))) {
                        a.remove(j);
                    }
                }
            }
        }
        else {
            a.clear();
            throw new CorruptedDataException();
        }
        System.out.println("После удаления эквивалентных строк:");
        System.out.println("Вывод первого файла:");
        for (String line : a) System.out.println(line);
        System.out.println("Вывод второго файла:");
        for (String line : b) System.out.println(line);
    }
}