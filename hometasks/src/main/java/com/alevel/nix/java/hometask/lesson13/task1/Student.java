package com.alevel.nix.java.hometask.lesson13.task1;

public class Student {
    final String fullName;
    int age;

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
