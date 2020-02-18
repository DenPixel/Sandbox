package com.alevel.java.nix.level1.task2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StepHorseTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void canHorseStep() {
        test(true,50, 50, 52, 51);
        test(true,50, 50, 51, 52);
        test(true,50, 50, 48, 49);
        test(true,50, 50, 49, 48);
        test(false,50, 50, 52,52);
        test(false,50, 50, 49, 47);
    }

    void test(boolean expRes, int startX, int startY, int finishX, int finishY){
        StepHorse sh = new StepHorse();
        assertEquals(expRes, sh.canHorseStep(startX, startY, finishX,finishY));
    }
}