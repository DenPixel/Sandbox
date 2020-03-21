package com.alevel.nix.java.hometask.lesson17.practice;

import java.time.*;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class DateAndTime {


    public SortedMap<LocalDate, SortedSet<LocalTime>> grouping(List<LocalDateTime> list){

        //реализация Миши
        return list.stream().collect(groupingBy(
                LocalDateTime::toLocalDate,
                TreeMap::new,
                mapping(LocalDateTime::toLocalTime, toCollection(TreeSet::new))
        ));

    }


    public Duration maxDistance(List<LocalDateTime> list){
        
        List<LocalDateTime> l = list.stream()
                .filter(Objects::nonNull)
                .sorted()
                .collect(Collectors.toList());

        return Duration.between(l.get(0), l.get(l.size()-1));
    }


}
