package com.javarush.task.task22.task2212;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Проверка номера телефона
*/
public class Solution {
    public static Pattern VALID_REGEX;
    public static Matcher matcher;
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber.charAt(0) == '+') {
            VALID_REGEX = Pattern.compile("^\\+[0-9]{12}$", Pattern.CASE_INSENSITIVE);
            if (telNumber.contains("(") && telNumber.contains(")"))
                VALID_REGEX = Pattern.compile("^\\+[0-9]{2}[(][0-9]{3}[)][0-9]{7}$", Pattern.CASE_INSENSITIVE);
            else if (telNumber.contains("-"))
                VALID_REGEX = Pattern.compile("^\\+[0-9]{8}[-][0-9]{2}[-][0-9]{2}$", Pattern.CASE_INSENSITIVE);
        }
        else if (telNumber.charAt(0)=='0'||telNumber.charAt(0)=='1'||telNumber.charAt(0)=='2'||telNumber.charAt(0)=='3'||telNumber.charAt(0)=='4'||telNumber.charAt(0)=='5'||telNumber.charAt(0)=='6'||telNumber.charAt(0)=='7'||telNumber.charAt(0)=='8'||telNumber.charAt(0)=='9') {
            VALID_REGEX = Pattern.compile("^[0-9]{6}[-][0-9]{4}$", Pattern.CASE_INSENSITIVE);
        }
        matcher = VALID_REGEX .matcher(telNumber);
        return matcher.find();
    }

    public static void main(String[] args) {

    }
}
