package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        String randomUppers = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String randomLowers = "abcdefghijklmnopqrstuvwxyz";
        String randomNumbers = "0123456789";
        String random = randomUppers + randomLowers + randomNumbers;


        int randomUpper = (int) (Math.random()*25);
        int randomLower = (int) (Math.random()*25);
        int randomNumber = (int) (Math.random()*9);

        byteArrayOutputStream.write(randomUppers.charAt(randomUpper));
        byteArrayOutputStream.write(randomLowers.charAt(randomLower));
        byteArrayOutputStream.write(randomNumbers.charAt(randomNumber));

        for (int i = 0; i < 5; i++) {
            byteArrayOutputStream.write(random.charAt((int) (Math.random()*61)));
        }

        return byteArrayOutputStream;
    }
}