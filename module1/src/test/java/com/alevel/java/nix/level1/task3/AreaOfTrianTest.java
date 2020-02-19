package com.alevel.java.nix.level1.task3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AreaOfTrianTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void areaOfTriangle() {
        test(6,5,-1, -7, 2,1,1);
        test(222.5,15, 15, 23, 30, 50, 25);
        test(120, -35, 13, -17, 36, -23, 15);
        test(390, -38, -3, -17, 36, -18, -3);
        test(28.50, 5, 6, 8, 12, 16, 9);
        test(216.38,34.6, 54.2, 23, 4.2, 43, 53.1);
        test(0, 0, 0, 0, 0, 0,0);
    }

    void test(double expRes, double xA, double yA, double xB, double yB, double xC, double yC){
        AreaOfTrian aot = new AreaOfTrian();
        assertEquals(expRes,aot.areaOfTriangle(new Point(xA,yA), new Point(xB,yB), new Point(xC,yC)));
    }

}