package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine(); //Вводим строку
        char[] chars = s.toCharArray(); //Перегоняем строку в массив чар для посимвольного сравнения
        ArrayList<Integer> list = new ArrayList<Integer>(); //Массив будет хранить индексы для обрезки
        ArrayList<String> list2 = new ArrayList<String>(); //Обрезанный массив со знаками равенства - стринг
        ArrayList<String> list3 = new ArrayList<String>(); //Стринговый массив с параметрами
        ArrayList<String> list4 = new ArrayList<String>(); //Стринговый массив с потенциальными str или double

        for (int i = 0; i < chars.length; i++) { //посимвольная сверка
            if (chars[i]=='?' || chars[i]=='&') { //записываем индексы в массив, если они содержат эти символы
                list.add(i+1);
            }
        }
        for(int i = 0; i < list.size()-1; i++){ //создаем обрезанный массив из искомой строки, с помощью индексов
            String str = s.substring(list.get(i),(list.get(i+1))-1);
            list2.add(str);
            if (i == list.size()-2) {
                i+=1;
                String str2 = s.substring(list.get(i));
                list2.add(str2);
            }
        }

        for (int i = 0; i < list2.size(); i++) { //отделяем не obj параметры, а если они obj - записываем в новый массив
            if (list2.get(i).contains("=") && list2.get(i).contains("obj")) { //массив общий и массив со значениями obj
                int j = list2.get(i).lastIndexOf("=");
                String str = list2.get(i).substring(0,j); //отрезаем obj от "="
                String str2 = list2.get(i).substring(j+1); //берем значение obj после "="
                list3.add(str);
                list4.add(str2);
            }
            else if (list2.get(i).contains("=")) { //отрезаем части после "=", если это не obj
                int j = list2.get(i).lastIndexOf("=");
                String str = list2.get(i).substring(0,j);
                list3.add(str);
            }
            else { //добавляем остатки в финальный массив параметров
                list3.add(list2.get(i));
            }
        }

        for (int i = 0; i < list3.size(); i++) { //Вывод параметров
            System.out.print(list3.get(i)+ " ");
        }

        System.out.println(); //Отступ

        for (int i = 0; i < list4.size(); i++) { //Вывод значений obj, их анализ и финал с передачей в виде аргумента
             if (isDouble(list4.get(i))) { //Является ли строка double? да : нет //В один из методов (String или Double)
                double d = Double.parseDouble(list4.get(i));
                alert(d);
            }
            else {
                 alert(list4.get(i));
             }
        }
    }

    public static boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }


}
