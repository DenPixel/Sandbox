package com.alevel.nix.java.hometask.lesson19.practice;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

public class BirthdayEmployees {

    private final Map<Month, Integer> count;

    private BirthdayEmployees(Map<Month, Integer> count) {
        this.count = count;
    }

//    public Map<Month, Integer> birthdayEmployees(Collection<LocalDate> birthdays){
//        return birthdays.stream()
//                .collect(Collectors.groupingBy());
//    }
}
