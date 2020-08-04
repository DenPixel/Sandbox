package com.pixel.sandbox.students_group;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GroupTest {
    Group group = new Group();

    @BeforeEach
    void setUp() {
        group.addStudents(
                new ContractStudent("Bondarenko Denis", 19, 8500),
                new Student("Sokolskiy Maxim", 19),
                new ContractStudent("Bobrishev Dmitriy", 19, 8500),
                new ContractStudent("Ivanova Ira", 18, 9300),
                new Student("Krasnokutskiy Vadim", 18),
                new ContractStudent("Svidlo Denis", 19, 8000)
                );
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addStudents() {
        group.addStudents(new ContractStudent("Ivanov Ivan", 18, 10000));
        group.viewGroupList();
        group.viewContractStudents();
    }

    @Test
    void delStudentByIndex() {
        group.delStudentByIndex(3);
        group.viewGroupList();
    }

    @Test
    void viewGroupList() {
        group.viewGroupList();
    }

    @Test
    void viewContractStudents() {
        group.viewContractStudents();
    }

}