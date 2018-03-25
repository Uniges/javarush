package com.javarush.task.task21.task2109;

/* 
Запретить клонирование
*/
public class Solution {
    public static class A implements Cloneable {

        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }

    public static class B extends A {

        public Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }

        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class C extends B {

        public C clone() throws CloneNotSupportedException {
            C c = new C(this.getI(),this.getJ(),this.getName());
            return c;
        }

        public C(int i, int j, String name) {
            super(i, j, name);
        }
    }

    public static void main(String[] args) {

    }
}
