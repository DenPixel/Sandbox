package com.alevel.nix.java.hometask.lesson10;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedianOfTwoSortedArraysTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findMedianSortedArrays() {
        test(2,new int[]{1,3},new int[]{2});
        test(2.5, new int[]{1,2}, new int[]{3,4});
//        test(9,new int[]{3,9,1,88}, new int[]{2,77,59});
//        test(34,new int[]{3,9,1,88}, new int[]{2,77,59,99});
    }

    void test(double expRes, int[] nums1, int[] nums2){{
        MedianOfTwoSortedArrays motsa = new MedianOfTwoSortedArrays();
        assertEquals(expRes, motsa.findMedianSortedArrays(nums1, nums2));
    }

    }
}