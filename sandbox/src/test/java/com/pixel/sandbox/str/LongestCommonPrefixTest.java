package com.pixel.sandbox.str;

import com.pixel.sandbox.str.LongestCommonPrefix;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class LongestCommonPrefixTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void longestCommonPrefix() {

        test("fl","flower","flow","flight");
        test("","dog","racecar","car");
        test("a","a");
        test("", "a", "b");
        test("","aca", "cba");

    }

    void test(String expRes, String ... strs){
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        assertArrayEquals(expRes.toCharArray(),lcp.longestCommonPrefix(strs).toCharArray());
    }
}