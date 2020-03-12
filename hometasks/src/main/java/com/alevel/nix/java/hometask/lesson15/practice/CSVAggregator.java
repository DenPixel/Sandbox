package com.alevel.nix.java.hometask.lesson15.practice;

public class CSVAggregator implements Aggregator<String,Object> {
    @Override
    public String aggregate(Object[] items) {
        if (items == null) throw new NullPointerException();
        String first = String.valueOf(items[0]);
        if (items.length == 1) return first;

        StringBuilder str = new StringBuilder(first);
        for (int i = 1, length = items.length; i < length; i++) {
            str.append(", ").append(items[i]);
        }

        return str.toString();
    }
}
