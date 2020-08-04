package com.pixel.sandbox.str;

import com.pixel.sandbox.arrays.ContainerWithMostWater;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ContainerWithMostWaterTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getContainerArea() {
        test(49, 1,8,6,2,5,4,8,3,7);
        test(0, 5);
        test(36, 9, 30, 32, 4, 9, 2);
        test(6,-5,-9,2,-7,-20,2);
    }

    void test(int expRes, int ... arr){
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater(arr);

        assertEquals(expRes, containerWithMostWater.getContainerArea());
    }
}