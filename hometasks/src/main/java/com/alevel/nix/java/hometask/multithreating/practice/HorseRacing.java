package com.alevel.nix.java.hometask.multithreating.practice;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class HorseRacing {
    private int countHorse = 5;
    private Scanner scanner = new Scanner(System.in);
    private PrintStream print = new PrintStream(System.out);
    private CountDownLatch count;
    private AtomicInteger place = new AtomicInteger(0);
    private int distance = 1000;

    public void start() throws InterruptedException {
        int numberChosenHorse;
        place.set(0);

        print.println("Choose the number of the horse (from 1 to " + countHorse +"):");
        while (true){
            numberChosenHorse = scanner.nextInt();

            if (numberChosenHorse <= 0 || numberChosenHorse > countHorse){
                print.println("Number of the chosen horse should be from 1 to " + countHorse);
            }else {
                break;
            }
        }
        print.println("You have chosen horse №" + numberChosenHorse);

        count = new CountDownLatch(countHorse);

        Horse chosenHorse = null;

        for (int i = 0; i < countHorse; i++) {
            Horse horse = new Horse() ;
            if (i+1 == numberChosenHorse) chosenHorse = horse;
            new Thread(horse).start();
        }

        count.await();

        print.println("Your horse took " + chosenHorse.getTop() + " place");
    }

    private class Horse implements Runnable{
        private int top;

        @Override
        public void run() {
            int dist = distance;
            while (dist > 0){
                sleep();
                dist -= randomBetween(100, 200);
            }

            top = place.incrementAndGet();

            count.countDown();
        }

        private void sleep(){
            try {
                Thread.sleep(randomBetween(400, 500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private long  randomBetween(int from, int to){
            return (long) (from + Math.random() * (to-from));
        }

        public int getTop() {
            return top;
        }
    }

    public static class Builder{

        private static final int MIN_COUNT_HORSE = 2;
        private static final int MIN_DISTANCE = 300;

        private HorseRacing horseRacing = new HorseRacing();

        public Builder setCountHorse(int countHorse) {
            if (countHorse >= MIN_COUNT_HORSE) horseRacing.countHorse = countHorse;
            return this;
        }

        public Builder setScanner(InputStream inputStream) {
            if (inputStream != null) horseRacing.scanner = new Scanner(inputStream);
            return this;
        }

        public Builder setPrint(OutputStream outputStream) {
            if (outputStream != null) horseRacing.print = new PrintStream(outputStream);
            return this;
        }

        public Builder setScanner(Scanner scanner) {
            if (scanner != null) horseRacing.scanner = scanner;
            return this;
        }

        public Builder setPrint(PrintStream print) {
            if (print != null) horseRacing.print = print;
            return this;
        }

        public Builder setDistance(int distance) {
            if (distance >= MIN_DISTANCE) horseRacing.distance = distance;
            return this;
        }

        public HorseRacing build(){
            return horseRacing;
        }
    }
}
