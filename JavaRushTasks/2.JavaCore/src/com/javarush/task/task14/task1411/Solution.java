package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
User, Looser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;
        String k1="user", k2="loser", k3="coder", k4="proger";

        while ((key = reader.readLine()).equals(k1)||key.equals(k2)||key.equals(k3)||key.equals(k4))
        //тут цикл по чтению ключей, пункт 1
        {
            if (key.equals(k1)) person = new Person.User();
            else if (key.equals(k2)) person = new Person.Loser();
            else if (key.equals(k3)) person = new Person.Coder();
            else if (key.equals(k4)) person = new Person.Proger();
            //создаем объект, пункт 2

            doWork(person); //вызываем doWork

        }
    }

    public static void doWork(Person person) {
        if (person instanceof Person.User) ((Person.User) person).live();
        else if (person instanceof Person.Loser) ((Person.Loser) person).doNothing();
        else if (person instanceof Person.Coder) ((Person.Coder) person).coding();
        else if (person instanceof Person.Proger) ((Person.Proger) person).enjoy();
    }
}
