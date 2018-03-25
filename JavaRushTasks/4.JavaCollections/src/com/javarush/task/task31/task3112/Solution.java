package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("D:/MyDownloads"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        // implement this method

        //Создаем url для скачивания
        URL url = new URL(urlString);
        //Открываем поток для скачки
        InputStream inputStream = url.openStream();
        //Создаем времнный файл в директории для скачки
        //С downloadDirectory не принимает!
        Path tempFile = Files.createTempFile(/*downloadDirectory,*/"temp-", ".tmp");
        //Копируем файлы из потока во временный файл
        //С StandardCopyOption.REPLACE_EXISTING не принимает! А без него ошибка...
        Files.copy(inputStream, tempFile/*, StandardCopyOption.REPLACE_EXISTING*/);
        //Создаем путь, файл, в который мы поместим данные из временного файла
        Path result = Paths.get(downloadDirectory.toString() + urlString.substring(urlString.lastIndexOf("/")));
        //Перемещаем данные
        Files.move(tempFile, result);
        //Возвращаем результат
        return result;
    }
}
