package com.pixel.sandbox.streams;

import java.time.Year;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class LeepYear {

    private boolean neededYear(Year year){
        int yvalue = year.getValue();
        if (yvalue%400 == 0){
            return true;
        }

        return yvalue % 4 == 0 && (yvalue % 100 != 0);
    }

    public List<Year> returnYear(Collection<Year> list){
        return list.stream()
                .filter(this::neededYear)
                .sorted()
                .collect(Collectors.toList());
    }
}
