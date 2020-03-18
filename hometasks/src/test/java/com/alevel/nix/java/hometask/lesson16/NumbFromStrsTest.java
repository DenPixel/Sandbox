package com.alevel.nix.java.hometask.lesson16;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumbFromStrsTest {

    @Test
    void getNumbFromStrs() {
        NumbFromStrs nfs = new NumbFromStrs();
        nfs.getNumbFromStrs("string 1 text", "2 string 3 text", "45");
    }
}