package com.alevel.java.nix.level2.task1;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class SequenceOfBracketsTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void isLineValid() {
        test(true,"");
        test(true, "[]");
        test(true, "({}[])");
        test(true, "vf()");
        test(false, "[][");
        test(true, "()jkfvj");
        test(false, "jgnbg((])");
        test(true, "{jgbnjng}jgbj");
    }
    
    void test(boolean expRes, String str){
        SequenceOfBrackets sob = new SequenceOfBrackets();
        assertEquals(expRes, sob.isLineValid(str));
    }
}