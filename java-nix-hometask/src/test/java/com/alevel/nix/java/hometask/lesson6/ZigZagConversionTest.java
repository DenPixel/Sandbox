package com.alevel.nix.java.hometask.lesson6;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZigZagConversionTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getNewStr() {
        test("dfivorohykjonnig", "dvynkofrjiooihng", 4);
    }

    void test(String expRes, String str, int numRows){
        ZigZagConversion zigZagConversion = new ZigZagConversion(str, numRows);

        assertArrayEquals(expRes.toCharArray(), zigZagConversion.getNewStr().toCharArray());
    }
}