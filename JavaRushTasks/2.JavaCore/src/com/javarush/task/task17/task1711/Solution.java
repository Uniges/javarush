package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        switch (args[0]) {
            case "-u" :
                synchronized (allPeople) {
                    if (((args.length - 1) % 4) == 0) {
                        for (int i = 1; i < args.length; i += 4) {
                            int id = Integer.parseInt(args[i]);
                            String name = args[i + 1];
                            String sex = args[i + 2];
                            String birthday = args[i + 3];
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
                }
                break;
            case "-c" :
                synchronized (allPeople) {
                    if (((args.length - 1) % 3) == 0) {
                        for (int i = 1; i < args.length; i += 3) {
                            String name = args[i];
                            String sex = args[i + 1];
                            String birthday = args[i + 2];
                            SimpleDateFormat oldDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                            Date date = null;
                            try {
                                date = oldDateFormat.parse(birthday);
                            } catch (ParseException e) {
                            }
                            if (sex.equals("м")) {
                                allPeople.add(Person.createMale(name, date));
                                System.out.println(allPeople.size() - 1);
                            } else if (sex.equals("ж")) {
                                allPeople.add(Person.createFemale(name, date));
                                System.out.println(allPeople.size() - 1);
                            }
                        }
                    }
                }
                break;
            case "-d" :
                if (args.length > 1) {
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i++) {
                            int id = Integer.parseInt(args[i]);
                            allPeople.get(id).setName(null);
                            allPeople.get(id).setSex(null);
                            allPeople.get(id).setBirthDay(null);
                        }
                    }
                }
                break;
            case "-i" :
                synchronized (allPeople) {
                    if (args.length > 1) {
                        for (int i = 1; i < args.length; i++) {
                            int id = Integer.parseInt(args[i]);
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
                break;
        }
    }
}
