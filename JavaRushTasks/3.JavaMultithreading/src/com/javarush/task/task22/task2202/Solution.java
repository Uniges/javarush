package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        if (string == null){
            throw new TooShortStringException();
        }
        int count = 0;
        int chNumber = 0;
        int lastIndex = 0;
        for (char ch : string.toCharArray()) {
            if (ch == ' ') count++;
            if (count == 4) lastIndex = chNumber + 1;
            chNumber++;
        }
        if (count < 4) throw new TooShortStringException();
        int firstIndex = string.indexOf(" ") + 1;
        return string.substring(firstIndex,lastIndex);
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
