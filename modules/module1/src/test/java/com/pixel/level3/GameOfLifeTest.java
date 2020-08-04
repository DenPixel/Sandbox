package com.pixel.level3;

import org.junit.jupiter.api.*;

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