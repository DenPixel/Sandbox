package com.alevel.nix.java.hometask.lesson4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleQuantityBitsTest {

    @Test
    void getQuantityBits() {
        SimpleQuantityBits simpleQuantityBits[] = new SimpleQuantityBits[3];
        int expRes[] = {9, 0, 56};

        simpleQuantityBits[0] = new SimpleQuantityBits(36824);
        simpleQuantityBits[1] = new SimpleQuantityBits(0);
        simpleQuantityBits[2] = new SimpleQuantityBits(-125824);

        assertEquals(expRes[0], simpleQuantityBits[0].getQuantityBits());
        assertEquals(expRes[1], simpleQuantityBits[1].getQuantityBits());
        assertEquals(expRes[2], simpleQuantityBits[2].getQuantityBits());
    }
}