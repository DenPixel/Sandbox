package com.pixel.sandbox.generics;

@FunctionalInterface
public interface Aggregator<A, T> {
    A aggregate(T[] items);
}
