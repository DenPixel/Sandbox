package com.pixel.sandbox.multithreating;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ThreadIOConsole implements Runnable {

    private String prevInput = "";
    private StringBuffer input = new StringBuffer(prevInput);
    private Scanner scanner = new Scanner(System.in);
    private String output;

    public ThreadIOConsole(String output) {
        this.output = output;
    }

    public void consoleInput(){
        input.append(scanner.next()).append(System.lineSeparator());
    }

    private void output(){
        try (FileWriter writer = new FileWriter(
                output,
                false
        )) {
            writer.write(prevInput);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        while(!input.toString().endsWith("quit\n")){

            if(!prevInput.contentEquals(input) &&
                    !input.toString().endsWith("quit\n")){
                prevInput = input.toString();
                output();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
