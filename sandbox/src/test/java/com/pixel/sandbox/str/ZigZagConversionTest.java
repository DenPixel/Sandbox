package com.pixel.sandbox.str;

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
        test("dfivorohcykjonbnig", "dvynkofrjiooihngbc", 4);
        test("dkjibvnoriohgcyfon", "dvynkofrjiooihngbc", 3);
        test("dykfjoinbvnoriohgc", "dvynkofrjiooihngbc", 2);
        test("dvynkofrjiooihngbc", "dvynkofrjiooihngbc", 1);
        test("HloyredelMFin", "HelloMyFriend", 2);
    }

    void test(String expRes, String str, int numRows){
        ZigZagConversion zigZagConversion = new ZigZagConversion(str, numRows);

        assertArrayEquals(expRes.toCharArray(), zigZagConversion.getNewStr().toCharArray());
    }
}