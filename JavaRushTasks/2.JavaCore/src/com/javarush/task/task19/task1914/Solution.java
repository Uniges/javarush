package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String s = outputStream.toString();
        System.setOut(consoleStream);
        String[] sArr = s.split(" ");
        int a = Integer.parseInt(sArr[0]);
        int b = Integer.parseInt(sArr[2]);
        int c = 0;
        if (sArr[1].equals("+")) c = a + b;
        else if (sArr[1].equals("-")) c = a - b;
        else if (sArr[1].equals("*")) c = a * b;
        System.out.print(sArr[0]+" "+sArr[1]+" "+sArr[2]+" "+sArr[3]+" "+c);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

