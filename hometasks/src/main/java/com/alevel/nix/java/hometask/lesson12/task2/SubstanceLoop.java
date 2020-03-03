package com.alevel.nix.java.hometask.lesson12.task2;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class SubstanceLoop {
    private final static Logger log = LoggerFactory.getLogger(SubstanceLoop.class);
    private Substance substance;

    SubstanceLoop(Substance substance) {
        this.substance = substance;
    }

    public void runLoop(){
        Scanner scanner = new Scanner(System.in);
        double t = -1;
        while (t != 0){
            log.info("Choise temperature: ");
            t = scanner.nextDouble();
            log.info("State of Substanse: " + substance.heatUp(t).toString());
            log.info("Substance temperature: " + substance.getTemperature());
            log.info("Enter 0 to exit");
            t = scanner.nextDouble();
        }

    }
}
