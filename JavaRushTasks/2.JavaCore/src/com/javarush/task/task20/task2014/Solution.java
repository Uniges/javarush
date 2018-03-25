package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws IOException {
        /*System.out.println(new Solution(4));*/
        String filename = "D:/10.txt";
        File file = new File(filename);
        file.createNewFile();
        Solution savedObject = new Solution(4);

        FileOutputStream fileOutputStream = new FileOutputStream(filename);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(savedObject);
        fileOutputStream.close();
        objectOutputStream.close();

        Solution loadedObject = new Solution(5);
        FileInputStream fileInputStream = new FileInputStream(filename);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        try {
            loadedObject = (Solution)objectInputStream.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        fileInputStream.close();
        objectInputStream.close();

        if (savedObject.string.equals(loadedObject.string)) System.out.println("+");
        System.out.println(savedObject);
        System.out.println(loadedObject);
    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
