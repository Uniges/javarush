package com.javarush.task.task19.task1921;

import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        String s = "";
        while (fileReader.ready()) {
            s+=(char)fileReader.read();
        }
        fileReader.close();
        String[] lines = s.split("\\r?\\n");
        String[] linesResult;
        String name = "";
        String date = "";
        DateFormat format = new SimpleDateFormat("d M y");
        Date dateResult = null;
        for (String ss : lines) {
            linesResult = ss.split(" ");
            for (String sss : linesResult) {
                try {
                    Integer.parseInt(sss);
                    date+=sss + " ";
                } catch (NumberFormatException e) {
                    name+=sss + " ";
                }
            }
            try {
                dateResult = format.parse(date.substring(0, date.length()-1));
            } catch (ParseException e) {
            }
            name = name.substring(0, name.length()-1);
            PEOPLE.add(new Person(name, dateResult));
            name = "";
            date = "";
        }
    }
}
