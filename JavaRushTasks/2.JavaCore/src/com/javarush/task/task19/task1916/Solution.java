package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = bufferedReader.readLine();
        String file2 = bufferedReader.readLine();
        bufferedReader.close();
        FileReader fileReader1 = new FileReader(file1);
        FileReader fileReader2 = new FileReader(file2);
        String stringFile1 = "";
        String stringFile2 = "";
        while (fileReader1.ready()) stringFile1+=(char)fileReader1.read();
        while (fileReader2.ready()) stringFile2+=(char)fileReader2.read();
        fileReader1.close();
        fileReader2.close();
        String[] stringArrFile1 = stringFile1.split(System.lineSeparator());
        String[] stringArrFile2 = stringFile2.split(System.lineSeparator());
        int i = 0;
        in: for (int j = 0; j < stringArrFile1.length; j++) {
            if (i < stringArrFile2.length) {
                if (stringArrFile1[j].equals(stringArrFile2[i])) {
                    lines.add(new LineItem(Type.SAME, stringArrFile1[j]));
                    i++;
                    continue in;
                } else if (stringArrFile1[j].equals(stringArrFile2[i + 1])) {
                    lines.add(new LineItem(Type.ADDED, stringArrFile2[i]));
                    j--;
                    i++;
                    continue in;
                } else {
                    lines.add(new LineItem(Type.REMOVED, stringArrFile1[j]));
                    continue in;
                }
            }
            else {
                lines.add(new LineItem(Type.REMOVED, stringArrFile1[j]));
            }
        }
        while ( i < stringArrFile2.length ) {
            lines.add(new LineItem(Type.ADDED, stringArrFile2[i]));
            i++;
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
