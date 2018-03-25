package com.javarush.task.task33.task3303;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;


/*
Десериализация JSON объекта
*/
public class Solution {
    public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz) throws IOException {
        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String jsonString = bufferedReader.readLine();
        StringReader reader = new StringReader(jsonString);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(reader, clazz);*/
        return new ObjectMapper().readValue(new FileReader(new File(fileName)), clazz);
    }

    public static void main(String[] args) {

    }
}
