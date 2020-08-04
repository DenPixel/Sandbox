package com.pixel.sandbox.students_group;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContractStudentTest {
    ContractStudent student;

    @BeforeEach
    void setUp() {
        student = new ContractStudent("Bondarenko Denis", 19, 8100);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getContractCost() {
        student.getContractCost();
    }
}