package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null) throw new TooShortStringException();
        int tabCount = 0;
        for (char ch : string.toCharArray()) {
            if (ch == '\t') tabCount++;
        }
        if (tabCount < 2) throw new TooShortStringException();
        int firstIndex = string.indexOf("\t") + 1;
        int lastIndex = string.indexOf("\t", firstIndex);
        return string.substring(firstIndex, lastIndex);
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
