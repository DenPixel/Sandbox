package com.pixel.sandbox.students_group;

public class Student {
    private String fullName;
    private int age;

    Student(String fullName, int age){
        this.fullName = fullName;
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

}
