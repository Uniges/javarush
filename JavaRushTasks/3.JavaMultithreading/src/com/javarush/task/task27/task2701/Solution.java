package com.javarush.task.task27.task2701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Избавляемся от меток
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = "Ты чо сука?";
        String substring = "чо";
        //String substring = "чот";

        if (isSubstringPresent(substring, string)) {
            System.out.println("String: \n" + substring + "\nis present in the string: \n" + string);
        } else {
            System.out.println("String: \n" + substring + "\nis not present in the string: \n" + string);
        }
    }

    static boolean isSubstringPresent(String substring, String string) {
        boolean found = false;
        int max = string.length() - substring.length();
        for (int i = 0; i <= max; i++) {
            int length = substring.length();
            int j = i;
            int k = 0;
            int counter = 0;
            while (length-- != 0) {
                if (string.charAt(j++) != substring.charAt(k++)) {
                    i++;
                    length = substring.length();
                    k = 0;
                    j = i;
                    if (i > max) {
                        length = 0;
                        if (counter!=substring.length()) found = false;
                    }
                }
                else {
                    found = true;
                    counter++;
                }
            }
            i = max+1;
        }
        return found;
    }
}

