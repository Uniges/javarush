package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* 
Глубокое клонирование карты
*/
public class Solution implements Cloneable {
    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Solution)) return false;
        Solution solution = (Solution) o;
        return Objects.equals(users, solution.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users);
    }*/

    public Solution clone() throws CloneNotSupportedException {
        Solution solution = (Solution)super.clone();
        Map<String, User> users = new LinkedHashMap();
        for(Map.Entry<String,User> entry : this.users.entrySet()) {
            String key = entry.getKey();
            User value = entry.getValue();

            users.put(key, value);
        }
        solution.users = users;
        return solution;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    protected Map<String, User> users = new LinkedHashMap();

    public static class User implements Cloneable {

        public User clone() throws CloneNotSupportedException {
            return (User) super.clone();
        }

        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }
}
