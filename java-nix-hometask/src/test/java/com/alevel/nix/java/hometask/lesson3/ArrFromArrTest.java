package com.alevel.nix.java.hometask.lesson3;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ArrFromArrTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getNewArr() {
        int arr[] = {26, 13, 2, 65};
        int k = 2;
        int expRes[] ={26,2} ;
        ArrFromArr arrFromArr = new ArrFromArr(arr, k);
        assertArrayEquals(expRes,arrFromArr.getNewArr());
    }
}