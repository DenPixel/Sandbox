package com.alevel.nix.java.hometask.multithreating.practice;

import java.util.concurrent.CountDownLatch;

public class Horse implements Runnable{
    private static int possiblePlace = 0;
    private static CountDownLatch count;
    private int top;
    private int number;
    private int speed = 100;
    private  int distance = 1000;

    public Horse(int number) {
        this.number = number;
    }

    public Horse(int number, int speed) {
        this.number = number;
        this.speed = speed;
    }

    public Horse(int number, int speed, int distance) {
        this.number = number;
        this.speed = speed;
        this.distance = distance;
    }

    @Override
    public void run() {

        while (distance > 0){
            sleepSecond();

            distance -= speed;
        }


        top = ++possiblePlace;
    }

    private void sleepSecond(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getTop() {
        return top;
    }

    public int getNumber() {
        return number;
    }
}
