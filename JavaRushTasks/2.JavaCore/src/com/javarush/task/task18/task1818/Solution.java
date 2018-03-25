package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        String s3 = reader.readLine();
        FileOutputStream f1 = new FileOutputStream(s1);
        FileInputStream f2 = new FileInputStream(s2);
        FileInputStream f3 = new FileInputStream(s3);
        if (f2.available() > 0 && f3.available() > 0) {
            byte[] buffer2 = new byte[f2.available()];
            byte[] buffer3 = new byte[f3.available()];
            int count2 = f2.read(buffer2);
            int count3 = f3.read(buffer3);
            f1.write(buffer2);
            f1.write(buffer3);
        }
        f1.close();
        f2.close();
        f3.close();
    }
}
