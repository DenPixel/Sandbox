package com.pixel.sandbox.streams;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;

public class MyDoubleStatistics {
    private final double min;
    private final double max;
    private final double avg;
    private final double sum;

    private MyDoubleStatistics(double min, double max, double avg, double sum) {
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

    public static MyDoubleStatistics MaxMinAvgSum(double ... arrs){
        DoubleSummaryStatistics statistics = Arrays.stream(arrs).summaryStatistics();

        return new MyDoubleStatistics(
                statistics.getMin(),
                statistics.getMax(),
                statistics.getAverage(),
                statistics.getSum()
        );
    }

}
