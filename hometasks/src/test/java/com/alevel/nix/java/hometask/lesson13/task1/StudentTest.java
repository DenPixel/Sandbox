package com.alevel.nix.java.hometask.lesson13.task1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    Student student;

    @BeforeEach
    void setUp() {
        student = new Student("Bondarenko Denis", 19);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getFullName() {
        System.out.println(student.getFullName());

    }

    @Test
    void getAge() {
        System.out.println(student.getAge());
    }
}