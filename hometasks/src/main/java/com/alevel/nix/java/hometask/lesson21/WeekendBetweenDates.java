package com.alevel.nix.java.hometask.lesson21;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WeekendBetweenDates {
    static public Optional<List<LocalDate>> weekend(String startDay, String endDay){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        LocalDate startDate = LocalDate.parse(startDay, formatter);
        LocalDate endDate = LocalDate.parse(endDay, formatter);

        List<LocalDate> weekends = new ArrayList<>();

        while(startDate.isBefore(endDate)){
            if (DayOfWeek.SATURDAY.equals(startDate.getDayOfWeek())){
                weekends.add(startDate);
                weekends.add(startDate.plusDays(1));
                startDate = startDate.plusDays(6);
            } else if (DayOfWeek.SUNDAY.equals(startDate.getDayOfWeek())){
                weekends.add(startDate);
                startDate = startDate.plusDays(6);
            }else{
                startDate = startDate.plusDays(1);

            }
        }

        if (weekends.isEmpty()){
            return Optional.empty();
        }

        return Optional.of(weekends);
    }

    private WeekendBetweenDates() {
    }

    public static void main(String[] args) {

        WeekendBetweenDates.weekend("20200101", "20200201").ifPresent(
                localDates -> localDates.forEach(System.out::println));
    }
}
