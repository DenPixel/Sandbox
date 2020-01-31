package com.alevel.java.nix.programmingday;

import java.time.LocalDate;

public class SimpleDateWizard implements DateWizard {

    @Override
    public LocalDate getDateOfYear(int year, int day) {
        return LocalDate.ofYearDay(year, day);
    }
}
