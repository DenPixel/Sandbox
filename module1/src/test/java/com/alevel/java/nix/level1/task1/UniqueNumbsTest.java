package com.alevel.java.nix.level1.task1;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class UniqueNumbsTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void countUniqueNumbs() {
        test(4,1,3,2,1,1,5);
        test(1,2);
        test(3, -1, 0, 1);
        test(1, 0);
        test(5, -532, -5, 0, 65, 5151, -532, 0, 5151);
    }

    void test(int expRes, int ... numbs){
        UniqueNumbs un = new UniqueNumbs();
        assertEquals(expRes, un.countUniqueNumbs(numbs));
    }
}