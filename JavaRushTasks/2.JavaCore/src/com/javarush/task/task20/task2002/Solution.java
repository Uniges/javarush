package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user1 = new User();
            user1.setFirstName("Имя");
            user1.setLastName("Фамилия");
            user1.setBirthDate(new Date());
            user1.setCountry(User.Country.RUSSIA);
            user1.setMale(true);

            User user2 = new User();
            user2.setFirstName("Имя2");
            user2.setLastName("Фамилия2");
            user2.setBirthDate(new Date());
            user2.setCountry(User.Country.OTHER);
            user2.setMale(true);

            javaRush.users.add(user1);
            javaRush.users.add(user2);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            if (javaRush == loadedObject) {
                outputStream.close();
                inputStream.close();
            }
            /*for (User u : loadedObject.users) {
                System.out.println(u.getFirstName());
                System.out.println(u.getLastName());
                System.out.println(u.getBirthDate());
                System.out.println(u.getCountry());
                System.out.println(u.isMale());
            }*/

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            for (User u : users) {
                if (u.getFirstName() != null)
                printWriter.println(u.getFirstName());
                if (u.getLastName() != null)
                printWriter.println(u.getLastName());
                if (u.getBirthDate() != null)
                printWriter.println(u.getBirthDate().getTime());
                if (u.getCountry() != null)
                printWriter.println(u.getCountry());
                printWriter.println(u.isMale());
            }
            printWriter.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            int i = 0;
            while (reader.ready()) {
                users.add(i, new User());
                String line;
                if ((line = reader.readLine()) != null) users.get(i).setFirstName(line);
                if ((line = reader.readLine()) != null) users.get(i).setLastName(line);
                if ((line = reader.readLine()) != null) users.get(i).setBirthDate(new Date(Long.parseLong(line)));
                if ((line = reader.readLine()) != null) users.get(i).setCountry(User.Country.valueOf(line));
                if ((line = reader.readLine()) != null) users.get(i).setMale(Boolean.parseBoolean(line));
                i++;
            }
            reader.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
