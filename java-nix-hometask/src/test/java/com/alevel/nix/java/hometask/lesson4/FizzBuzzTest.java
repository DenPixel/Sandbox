package com.alevel.nix.java.hometask.lesson4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getDivisorStr() {
        FizzBuzz fizzBuzz[] = new FizzBuzz[3];
        String expStr[] ={"fizz fizz fizzbuzz buzz fizzbuzz fizz ",
                "",
                "fizz buzz fizz fizzbuzz "};

        fizzBuzz[0] = new FizzBuzz(-4_637_628);
        fizzBuzz[1] = new FizzBuzz(0);
        fizzBuzz[2] = new FizzBuzz(15_675_298);

        assertArrayEquals(expStr[0].toCharArray(), fizzBuzz[0].getDivisorStr().toCharArray());
        assertArrayEquals(expStr[1].toCharArray(), fizzBuzz[1].getDivisorStr().toCharArray());
        assertArrayEquals(expStr[2].toCharArray(), fizzBuzz[2].getDivisorStr().toCharArray());
    }
}