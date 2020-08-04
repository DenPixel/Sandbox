package com.pixel.sandbox.str;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getCountRepeatChar() {
        test(3, "ghghj");
        test(0, "");
        test(6, "qwerty");
        test(3, "qweqweqweqwe");
        test(3, "qwwkew");
        test(2, "azazazaza");
    }

    private void test(int expRes, String subStr){
        LongestSubstring lonsub = new LongestSubstring(subStr);
        assertEquals(expRes, lonsub.getCountRepeatChar());
    }
}