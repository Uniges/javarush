package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University extends UniversityPerson {

    protected String name;
    protected int age;
    private List<Student> students = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }



    public University(String name, int age) {
        super(name, age);
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:
        Student student = null;
        for (Student stud : students) {
            if (stud.getAverageGrade()==averageGrade) {
                student = stud;
                break;
            }
        }
        return student;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        Student student = students.get(0);
        for (Student stud : students) {
            if (stud.getAverageGrade() > student.getAverageGrade()) {
                student = stud;
            }
        }
        return student;
    }

    public Student getStudentWithMinAverageGrade() {
        Student student = students.get(0);
        for (Student stud : students) {
            if (stud.getAverageGrade() < student.getAverageGrade()) {
                student = stud;
            }
        }
        return student;
    }

    public void expel(Student student) {
        students.remove(student);
    }
}