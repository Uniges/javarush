package com.javarush.task.task14.task1419;

import javax.jws.WebService;
import javax.xml.crypto.Data;
import java.io.FileInputStream;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            int[] cats = new int[10];
            int i = cats[10];
        }
        catch (Exception e) {
            exceptions.add(e);
        }

        try {
            String s = "12345";
            char ch = s.charAt(5);
        }
        catch (Exception e) {
            exceptions.add(e);
        }

        try {
            int[] cats = new int[10];
            for (int i = cats.length - 1; i>-2; i--)
                cats[i]=i;
        }
        catch (Exception e) {
            exceptions.add(e);
        }

        try {
            FileInputStream fis = new FileInputStream("C2:\badFileName.txt");
        }
        catch (Exception e) {
            exceptions.add(e);
        }

        try {
            throw new Exception();
        }
        catch (Exception e) {
            exceptions.add(e);
        }

        try {
            Object x = new Integer(0);
            System.out.println((String)x);
        }
        catch (Exception e) {
            exceptions.add(e);
        }

        try {
            int a[] = new int[-4];
        }
        catch (Exception e) {
            exceptions.add(e);
        }

        try {
            Object x[] = new String[3];
            x[0] = new Integer(0);
        }
        catch (Exception e) {
            exceptions.add(e);
        }

        try {
            Object object = new Object();
            System.out.println(object);
        }
        catch (Exception e) {
            exceptions.add(e);
        }
        try {
            Object x = new Double(5.55);
            System.out.println((String)x);
        }
        catch (Exception e) {
            exceptions.add(e);
        }
    }
}
