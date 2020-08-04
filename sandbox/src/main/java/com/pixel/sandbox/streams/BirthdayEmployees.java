package com.pixel.sandbox.streams;

import java.time.Month;
import java.util.Map;

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
