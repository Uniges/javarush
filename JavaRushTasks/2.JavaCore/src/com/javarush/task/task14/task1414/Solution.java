package com.javarush.task.task14.task1414;

/*
MovieFactory
*/

        import java.io.BufferedReader;
        import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //ввести с консоли несколько ключей (строк), пункт 7
        String key;
        String k1="cartoon",k2="thriller",k3="soapOpera";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int j = 1;
        while (j==1) {
            key = reader.readLine();
            if (key.equals(k1)||key.equals(k2)||key.equals(k3)) {
                Movie movie = MovieFactory.getMovie(key);
                System.out.println(movie.getClass().getSimpleName());
            }
            else {
                MovieFactory.getMovie(key);
                j++;
            }
        }
        /*
8 Создать переменную movie класса Movie и для каждой введенной строки(ключа):
8.1 получить объект используя MovieFactory.getMovie и присвоить его переменной movie
8.2 вывести на экран movie.getClass().getSimpleName()
        */

    }

    static class MovieFactory {

        static Movie getMovie(String key) {
            Movie movie = null;

            //создание объекта SoapOpera (мыльная опера) для ключа "soapOpera"
            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
            }

            else if ("thriller".equals(key)) {
                movie = new Thriller();
            }

            else if ("cartoon".equals(key)) {
                movie = new Cartoon();
            }

            //напишите тут ваш код, пункты 5,6

            return movie;
        }
    }

    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }

    //Напишите тут ваши классы, пункт 3

    static class Cartoon extends Movie {
    }

    static class Thriller extends Movie {
    }
}