package com.alevel.nix.java.hometask.lesson3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleFindMaxAndMinFromArrTest {

    @Test
    void getMax() {
        int arr[] = {26, 13, 2, 65};
        int expRes = 65;
        SimpleFindMaxAndMinFromArr s = new SimpleFindMaxAndMinFromArr(arr);
        assertEquals(expRes, s.getMax());
    }

    @Test
    void getMin() {
        int arr[] = {26, 13, 2, 65};
        int expRes = 2;
        SimpleFindMaxAndMinFromArr s = new SimpleFindMaxAndMinFromArr(arr);
        assertEquals(expRes, s.getMin());
    }
}