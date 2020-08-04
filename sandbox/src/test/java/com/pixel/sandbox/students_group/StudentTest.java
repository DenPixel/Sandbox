package com.pixel.sandbox.students_group;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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