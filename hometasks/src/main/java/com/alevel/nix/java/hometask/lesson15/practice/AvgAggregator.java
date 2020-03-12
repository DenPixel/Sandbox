package com.alevel.nix.java.hometask.lesson15.practice;

public class AvgAggregator implements Aggregator<Double, Number> {
    @Override
    public Double aggregate(Number[] items) {
        if (items == null) throw new NullPointerException();
        if (items.length == 1) return items[0].doubleValue();

        double sum = 0;

        for (Number item : items) {
            sum += item.doubleValue();
        }

        return sum / items.length;
    }
}
