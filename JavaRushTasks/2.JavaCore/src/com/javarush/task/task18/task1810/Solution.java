package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        Boolean isReady = true;
        while (isReady) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String name = reader.readLine();
            FileInputStream file = new FileInputStream(name);
            byte[] buffer = new byte[file.available()];
            int count = file.read(buffer);
            if (count < 1000) {
                file.close();
                reader.close();
                throw new DownloadException();
            }
            file.close();
            reader.close();
        }
    }

    public static class DownloadException extends Exception {

    }
}
