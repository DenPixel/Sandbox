package com.alevel.java.nix.level3;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class GameOfLifeTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void showCells() {
        GameOfLife gol = new GameOfLife( 5, 5);
        gol.showCells();
        gol.step();
        System.out.println();
        gol.showCells();
        gol.step();
        System.out.println();
        gol.showCells();
    }
}