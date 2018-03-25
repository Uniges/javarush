package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String > map = new LinkedHashMap<String, String>();
        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", null);
        System.out.println(getQuery(map));
    }
    public static String getQuery(Map<String, String> params) {
        String s = "";
        int i = 0;
        for(Map.Entry<String, String> entry : params.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key!=null && value!=null) {
                if (i==0) {
                    s += key + " = " + "'" + value + "'";
                    i++;
                }
                else if (i!=0) {
                    s +=  " and " + key + " = " + "'" + value + "'";
                }
            }
        }
        return s;
    }
}
