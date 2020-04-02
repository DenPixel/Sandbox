package com.alevel.nix.java.hometask.lesson19.practice;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;

public class Task1 {
    private final double min;
    private final double max;
    private final double avg;
    private final double sum;

    public Task1(double min, double max, double avg, double sum) {
        this.min = min;
        this.max = max;
        this.avg = avg;
        this.sum = sum;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    public double getAvg() {
        return avg;
    }

    public double getSum() {
        return sum;
    }

    public Task1 MaxMinAvSum(double ... arrs){
        DoubleSummaryStatistics statistics = Arrays.stream(arrs).summaryStatistics();

        return new Task1(statistics.getMin(), statistics.getMax(),statistics.getAverage(),statistics.getSum());
    }

}
