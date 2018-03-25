package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        if (args.length == 5) {
            if (args[0].equals("-u")) {
                int id = Integer.parseInt(args[1]);
                String name = args[2];
                String sex = args[3];
                String birthday = args[4];
                SimpleDateFormat oldDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                Date date = null;
                try {
                    date = oldDateFormat.parse(birthday);
                } catch (ParseException e) {
                }
                allPeople.get(id).setName(name);
                if (sex.equals("м")) allPeople.get(id).setSex(Sex.MALE);
                else if (sex.equals("ж")) allPeople.get(id).setSex(Sex.FEMALE);
                allPeople.get(id).setBirthDay(date);
            }
        }
        else if (args.length == 4) {
            if (args[0].equals("-c")) {
                String name = args[1];
                String sex = args[2];
                String birthday = args[3];
                SimpleDateFormat oldDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                Date date = null;
                try {
                    date = oldDateFormat.parse(birthday);
                } catch (ParseException e) {
                }
                if (sex.equals("м")) {
                    allPeople.add(Person.createMale(name, date));
                    System.out.println(allPeople.size()-1);
                }
                else if (sex.equals("ж")) {
                    allPeople.add(Person.createFemale(name, date));
                    System.out.println(allPeople.size()-1);
                }
            }
        }
        else if (args.length == 2) {
            if (args[0].equals("-d")) {
                int id = Integer.parseInt(args[1]);
                allPeople.get(id).setName(null);
                allPeople.get(id).setSex(null);
                allPeople.get(id).setBirthDay(null);
            }
            else if (args[0].equals("-i")) {
                int id = Integer.parseInt(args[1]);
                String name = allPeople.get(id).getName();
                String sex = null;
                if (allPeople.get(id).getSex() == Sex.MALE) sex = "м";
                else if (allPeople.get(id).getSex() == Sex.FEMALE) sex = "ж";
                SimpleDateFormat newDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                String birthday = newDateFormat.format(allPeople.get(id).getBirthDay());
                System.out.println(name + " " + sex + " " + birthday);
            }
        }
    }
}
