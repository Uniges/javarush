package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(s1);
        FileOutputStream fileOutputStream = new FileOutputStream(s2);
        if (fileInputStream.available() > 0) {
            byte[] buffer = new byte[fileInputStream.available()];
            int count = fileInputStream.read(buffer);
            String str = new String(buffer);
            String strArr[] = str.split(" ");
            int numArr[] = new int[strArr.length];
            String strFinal = "";
            for (int i = 0; i < strArr.length; i++) {
                strFinal += Math.round(Double.parseDouble(strArr[i]));
                if (i < numArr.length-1) strFinal+=" ";
            }
            System.out.println(strFinal);
            byte[] b = strFinal.getBytes();
            fileOutputStream.write(b);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
