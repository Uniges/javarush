package com.javarush.task.task25.task2512;

import java.util.ArrayList;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    /*public Solution(){
        try {
            throw new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));
        } catch (Exception e) {
            uncaughtException(Thread.currentThread(), e);
        }
    }*/

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        ArrayList<Throwable> list = new ArrayList<>();
        t.interrupt();
        while (e != null) {
            list.add(e);
            e = e.getCause();
        }
        for (int i = list.size()-1; i >= 0; i--) System.out.println(list.get(i));
    }

    public static void main(String[] args) {
        //Solution solution = new Solution();
    }
}
