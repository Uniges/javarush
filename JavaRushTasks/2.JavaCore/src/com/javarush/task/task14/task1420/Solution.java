package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import static java.lang.StrictMath.abs;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int a = Integer.parseInt(reader.readLine());
            int b = Integer.parseInt(reader.readLine());
            int max = 0;
            int div = 0;
            if (abs(a) > abs(b)) max = abs(a);
            else if (abs(a) < abs(b)) max = abs(b);
            else max = abs(a);

            for (int i = 1; i <= max; i++) {
                if ((a)%(i)==0 && b%(i)==0) div=i;
            }
            System.out.println(div);
    }

}
