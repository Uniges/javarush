package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        //Список строк - наш результат
        List<String> list = new ArrayList<>();
        //Файл-директория для парсинга
        File file = new File(root);
        //Очередь
        Queue<File> queue = new PriorityQueue<>();
        //Заполняем пустую очередь списоком файлов и дерикторий из корневой папки file.
        Collections.addAll(queue, file.listFiles());
        while (!queue.isEmpty()) {
            //Цикл перебирает все элементы до тех пор, пока они есть!
            //Берем элемент из очереди в переменную и удаляем(?) его
            File currentFile = queue.remove();
            //Если файл - директория, то добавляем все файлы и папки из этой директории в очередь
            //Динамичная очередь расширяется.
            if (currentFile.isDirectory()) Collections.addAll(queue, currentFile.listFiles());
            //Добавляем файл в результирующий список строк
            else list.add(currentFile.getAbsolutePath());
        }
        return list;
    }

    public static void main(String[] args) {
        
    }
}
