package com.alevel.nix.java.hometask.lesson19.practice;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrimeNumb {

    public List<BigInteger> primeNumbs(int limit){
        return Stream.iterate(BigInteger.TWO,BigInteger::nextProbablePrime)
                .limit(limit)
                .collect(Collectors.toList());
    }
}
