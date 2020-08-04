package com.pixel.sandbox.generics;

public class MaxAggregator<T extends Comparable<T>> implements Aggregator<T,T> {
    @Override
    public T aggregate(T[] items) {
        if (items == null) throw new NullPointerException();
        if (items.length == 1) return items[0];

        T maxItem = items[0];

        for (int i = 1, length = items.length; i < length; i++) {
            if (items[i].compareTo(maxItem) > 0) {
                maxItem = items[i];
            }
        }

        return maxItem;
    }
}
