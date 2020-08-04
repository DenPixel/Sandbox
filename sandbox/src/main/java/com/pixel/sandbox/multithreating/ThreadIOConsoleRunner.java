package com.pixel.sandbox.multithreating;

public class ThreadIOConsoleRunner {
    public static void main(String[] args) {
        String output = "output.txt";

        if (args.length > 0){
            output = args[0];
        }

        ThreadIOConsole tioc = new ThreadIOConsole(output);

        Thread thread = new Thread(tioc);
        thread.start();

        while (thread.isAlive()) {
            tioc.consoleInput();
        }

    }
}
