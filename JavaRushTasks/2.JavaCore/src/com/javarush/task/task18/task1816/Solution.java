package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        ArrayList<Byte> finalCase = new ArrayList<Byte>();
        char[] loverCase = new char[26];
        char[] upperCase = new char[26];
        int sum = 0;

        for (int i=0; i< 26; i++) {
            loverCase[i] = (char)('a' + i);
            upperCase[i] = (char)('A' + i);
        }
        for (int i = 0; i < 26; i++) {
            finalCase.add((byte)loverCase[i]);
            finalCase.add((byte)upperCase[i]);
        }

        if (inputStream.available() > 0) {
            byte[] buffer = new byte[inputStream.available()];
            int count = inputStream.read(buffer);
            for (byte a : buffer) {
                for (byte b : finalCase) {
                    if (a == b) sum++;
                }
            }
        }
        System.out.print(sum);
        inputStream.close();
    }
}
