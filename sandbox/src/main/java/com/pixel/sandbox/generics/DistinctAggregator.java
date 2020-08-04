package com.pixel.sandbox.generics;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

public class DistinctAggregator<T> implements Aggregator<Integer, T> {

    @Override
    public Integer aggregate(T[] items) {
        Objects.requireNonNull(items);
        if (items.length == 1) return 1;

        HashSet<T> uniOb = new HashSet<>(Arrays.asList(items));

        return uniOb.size();
    }
}
