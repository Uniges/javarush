package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String name = bufferedReader.readLine();
        FileReader fileReader = new FileReader(name);
        String string = "";
        while (fileReader.ready()) {
            string+=(char)fileReader.read();
        }
        /*System.out.println(string);*/

        StringBuilder sb;
        List<String> list = new LinkedList<>();
        for (String str : string.split(System.lineSeparator())) for (String s : str.split(" ")) list.add(s);
        /*for (String s : list) System.out.println(s);*/
        /*System.out.println("_____");*/
        in: for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                sb = new StringBuilder(list.get(j));
                if (list.get(i).equals(sb.reverse().toString())) {
                    /*System.out.println(list.get(i)+" -> "+list.get(j));*/
                    Pair pair = new Pair();
                    pair.first = list.get(i);
                    pair.second = list.get(j);
                    result.add(pair);
                    list.set(i, String.valueOf(Math.random()));
                    list.set(j, String.valueOf(Math.random()));
                    continue in;
                }
            }
        }
        for (Pair p : result) System.out.println(p);
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
