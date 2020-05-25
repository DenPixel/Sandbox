package com.alevel.nix.java.hometask.multithreating.practice;

public class HorseRacingRunner {
    public static void main(String[] args) {
        HorseRacing horseRacing = new HorseRacing.Builder()
                .setCountHorse(3)
                .setDistance(500)
                .build();

        try {
            horseRacing.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
