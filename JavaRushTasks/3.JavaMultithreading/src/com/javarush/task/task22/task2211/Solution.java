package com.javarush.task.task22.task2211;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/* 
Смена кодировки
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        /*byte[] buffer = win1251TestString.getBytes("Windows-1251");
        String s = new String(buffer, "UTF-8");
        System.out.println(win1251TestString);
        System.out.println(s);*/

        /*args = new String[]{"D:/1.txt", "D:/2.txt"};*/

        FileReader fileReader = new FileReader(args[0]);
        String string = "";
        while (fileReader.ready()) string+=(char)fileReader.read();
        fileReader.close();
        byte[] buffer = string.getBytes("Windows-1251");
        String s = new String(buffer, "UTF-8");
        FileWriter fileWriter = new FileWriter(args[1]);
        fileWriter.write(s);
        fileWriter.close();
    }
}
