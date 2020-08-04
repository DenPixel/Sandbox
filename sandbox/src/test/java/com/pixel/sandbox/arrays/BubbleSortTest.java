package com.pixel.sandbox.arrays;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void sortSmallToLarge() {
        int arr[] = {26, 13, 2, 65};
        int expRusult[] = {2, 13, 26, 65};
        BubbleSort bubbleSort = new BubbleSort(arr);
        bubbleSort.sortSmallToLarge();
        assertArrayEquals(expRusult, bubbleSort.getArr());
    }

    @Test
    void sortLargeToSmall() {
        int arr[] = {26, 13, 2, 65};
        int expRusult[] = {2, 13, 26, 65};
        BubbleSort bubbleSort = new BubbleSort(arr);
        bubbleSort.sortSmallToLarge();
        assertArrayEquals(expRusult, bubbleSort.getArr());
    }
}