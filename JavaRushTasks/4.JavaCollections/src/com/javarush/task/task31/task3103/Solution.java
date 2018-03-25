package com.javarush.task.task31.task3103;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/* 
Своя реализация
*/
public class Solution {
    public static byte[] readBytes(String fileName) throws IOException {
        return Files.readAllBytes(Paths.get(fileName));
    }

    public static List<String> readLines(String fileName) throws IOException {
        return Files.readAllLines(Paths.get(fileName), Charset.defaultCharset());
        /*List<String> list = new ArrayList<>();
        String s;
        while ((s = Files.newBufferedReader(Paths.get(fileName)).readLine()) != null) list.add(s);
        return list;*/
    }

    public static void writeBytes(String fileName, byte[] bytes) throws IOException {
        Files.newOutputStream(Paths.get(fileName)).write(bytes);
    }

    public static void copy(String resourceFileName, String destinationFileName) throws IOException {
        Files.copy(Paths.get(resourceFileName), Paths.get(destinationFileName));
    }
}
