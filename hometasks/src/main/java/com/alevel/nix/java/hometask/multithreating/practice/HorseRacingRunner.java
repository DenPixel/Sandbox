package com.alevel.nix.java.hometask.multithreating.practice;

public class HorseRacingRunner {
    public static void main(String[] args) {
        HorseRacing horseRacing = new HorseRacing();

        try {
            horseRacing.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
