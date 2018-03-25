package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }
    
    static {
        reset();
    }

    public static Flyable result;

    public static void reset() {
        //add your code here - добавьте код тут
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                String s = reader.readLine();
                if (s.equals("helicopter")) {
                    result = new Helicopter();
                    System.out.println(result);
                    reader.close();
                }
                else if(s.equals("plane")) {
                    int n = Integer.parseInt(reader.readLine());
                    result = new Plane(n);
                    System.out.println(result);
                    reader.close();
                }
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}
