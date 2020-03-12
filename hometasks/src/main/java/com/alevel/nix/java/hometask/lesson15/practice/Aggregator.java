package com.alevel.nix.java.hometask.lesson15.practice;

@FunctionalInterface
public interface Aggregator<A, T> {
    A aggregate(T[] items);
}
