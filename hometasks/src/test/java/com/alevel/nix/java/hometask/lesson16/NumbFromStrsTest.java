package com.alevel.nix.java.hometask.lesson16;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumbFromStrsTest {

    @Test
    void getNumbFromStrs() {
        NumbFromStrs nfs = new NumbFromStrs();

        test(12345,nfs.getNumbFromStrs("string 1 text", "2 string 3 text", "45"));
        test(215549,nfs.getNumbFromStrs("st2rin", "1jg", "55", "4jfj9"));
        test(0,nfs.getNumbFromStrs("0"));

    }

    void test(int expRes, int actRes){
        assertEquals(expRes,actRes);
    }
}