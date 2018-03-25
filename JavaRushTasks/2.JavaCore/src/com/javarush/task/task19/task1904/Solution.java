package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;
        public PersonScannerAdapter (Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String firstName = fileScanner.next();
            String middleName = fileScanner.next();
            String lastName = fileScanner.next();
            Date birthDate = null;
            SimpleDateFormat sdFormat = new SimpleDateFormat("ddMMyyyy");
            try {
                birthDate = sdFormat.parse(fileScanner.next() + fileScanner.next() + fileScanner.nextLine());
            } catch (ParseException e) {
            }
            return new Person(middleName, lastName, firstName, birthDate);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
