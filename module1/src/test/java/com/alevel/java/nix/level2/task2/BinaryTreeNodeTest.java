package com.alevel.java.nix.level2.task2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeNodeTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void maxDepth() {
        test(3, 6, 4, 8, 3, 5, 7, 9);
        test(1,0);
        test(4,3, 93, -94, 294, -2, 49, 94, -5);
        test();

    }

    void test(int epxRes, int ... vals){
        BinaryTreeNode btn = new BinaryTreeNode();

        for (int i = 0, length = vals.length; i < length; i++) {
            btn.add(vals[i]);
        }

        assertEquals(epxRes, btn.getMaxDepth());
    }

    void test(){
        BinaryTreeNode btn = new BinaryTreeNode();
        assertEquals(0, btn.getMaxDepth());
    }
}