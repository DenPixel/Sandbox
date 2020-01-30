package com.alevel.java.nix.programmingday;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class CachingDateWizard extends SimpleDateWizard {
    
    private final Map<Integer, Map<Integer, LocalDate>> cache = new HashMap<>();
    
    @Override
    public LocalDate getDateOfYear(int year, int day) {
        return cache
                .computeIfAbsent(year, key -> new HashMap<>())
                .computeIfAbsent(day, key -> super.getDateOfYear(year, day));
    }
}
