package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args[0] == "-u") {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            reader.close();

            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
            String line;
            int i = 0;
            int id = 0;
            List<String> list = new LinkedList<>();
            while ((line = fileReader.readLine()) != null) {
                list.add(line);
                if (Integer.parseInt(line.substring(0, 8).trim()) == Integer.parseInt(args[1])) {
                    id = i;
                }
                i++;
            }
            fileReader.close();

            FileOutputStream fos = new FileOutputStream(fileName);

            for (int j = 0; j < list.size(); j++) {
                if (j != id) {
                    fos.write((String.format("%s%n", list.get(j))).getBytes());
                }
                else {
                    fos.write(String.format("%-8s%-30s%-8s%-4s%n", args[1], args[2], args[3], args[4]).getBytes());
                }
            }
            fos.close();
        }
        if (args[0] == "-d") {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            reader.close();

            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
            String line;
            int i = 0;
            int id = 0;
            List<String> list = new LinkedList<>();
            while ((line = fileReader.readLine()) != null) {
                list.add(line);
                if (Integer.parseInt(line.substring(0, 8).trim()) == Integer.parseInt(args[1])) {
                    id = i;
                }
                i++;
            }
            fileReader.close();

            FileOutputStream fos = new FileOutputStream(fileName);

            for (int j = 0; j < list.size(); j++) {
                if (j == id) {
                }
                if (j != id) {
                    fos.write((String.format("%s%n", list.get(j))).getBytes());
                }
            }
            fos.close();
        }
    }
}
