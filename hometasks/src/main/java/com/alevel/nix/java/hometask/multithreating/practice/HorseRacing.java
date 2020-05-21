package com.alevel.nix.java.hometask.multithreating.practice;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class HorseRacing {
    private int countHorse = 5;
    private Scanner scanner = new Scanner(System.in);
    private PrintStream print = new PrintStream(System.out);
    private CountDownLatch count;
    private static int place;

    public HorseRacing() {
    }

    public HorseRacing(int countHorse) {
        this.countHorse = countHorse;
    }

    public HorseRacing(int countHorse, InputStream inputStream) {
        this.countHorse = countHorse;
        this.scanner = new Scanner(inputStream);
    }

    public HorseRacing(int countHorse, OutputStream outputStream) {
        this.countHorse = countHorse;
        this.print = new PrintStream(outputStream);
    }

    public HorseRacing(int countHorse, InputStream inputStream, OutputStream outputStream) {
        this.countHorse = countHorse;
        this.scanner = new Scanner(inputStream);
        this.print = new PrintStream(outputStream);
    }

    public void start() throws InterruptedException {
        int numberChosenHorse;
        place = 0;

        print.println("Choose the number of the horse (from 1 to " + countHorse +"):");
        while (true){
            numberChosenHorse = scanner.nextInt();

            if (numberChosenHorse <= 0 || numberChosenHorse > countHorse){
                print.println("Number of the chosen horse should be from 1 to " + countHorse);
            }else {
                break;
            }
        }
        print.println("You have chosen " + numberChosenHorse + " horse");

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
        private int speed = 100;
        private int distance = 1000;

        @Override
        public void run() {
            while (distance > 0){
                sleepSecond();
                distance -= speed;
            }

            top = ++place;

            count.countDown();
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
    }
}
