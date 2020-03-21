package com.alevel.nix.java.hometask.lesson17.practice;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DateAndTimeTest {

    DateAndTime dat = new DateAndTime();
    List<LocalDateTime> list = new ArrayList<>();

    @BeforeEach
    void setUp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        list.add(LocalDateTime.parse("2000-12-21 20:12",formatter));
        list.add(LocalDateTime.parse("2002-02-09 05:43",formatter));
        list.add(LocalDateTime.parse("2001-05-05 13:50",formatter));

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void grouping() {
    }

    @Test
    void maxDistance() {
        System.out.println(dat.maxDistance(list));
    }
}