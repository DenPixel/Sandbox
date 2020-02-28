package com.alevel.nix.java.hometask.lesson7;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImplemetReverseTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void subSeq() {
        test("helloworldssssdgbb","bbgdssssdlrowolleh");
        test("mnbvcxz","zxcvbnm");
        test("zasxcdfvbghnmjk", "kjmnhgbvfdcxsaz");
    }

    void test(CharSequence expRes, CharSequence str){
        ImplemetReverse im = new ImplemetReverse();
        assertEquals(expRes, im.reverse(str));
    }
}