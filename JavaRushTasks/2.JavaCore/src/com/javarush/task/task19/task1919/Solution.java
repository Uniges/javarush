package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<String, Double> map = new TreeMap<String, Double>();
        FileReader fileReader = new FileReader(args[0]);
        String s = "";
        while (fileReader.ready()) {
            s += (char) fileReader.read();
        }
        fileReader.close();
        String[] lines = s.split("\\r?\\n");
        String[] linesResult;
        String key = null;
        Double value = null;
        in: for (String ss : lines) {
            linesResult = ss.split(" ");
            for (Map.Entry<String, Double> entry : map.entrySet()) {
                key = entry.getKey();
                value = entry.getValue();
                if (key.equals(linesResult[0])) {
                    map.put(linesResult[0], Double.parseDouble(linesResult[1]) + value);
                    continue in;
                }
            }
            map.put(linesResult[0], Double.parseDouble(linesResult[1]));
        }
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            key = entry.getKey();
            value = entry.getValue();

            System.out.println(key + " " + value);
        }
    }
}
