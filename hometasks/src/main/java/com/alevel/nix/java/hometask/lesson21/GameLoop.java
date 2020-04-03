package com.alevel.nix.java.hometask.lesson21;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class GameLoop {
    private final static Logger log = LoggerFactory.getLogger(GameLoop.class);

    private static void start(){
        Gallows game = Gallows.build();
        Scanner scanner = new Scanner(System.in);
        int count = game.getCountClosedLetters();
        int life = 3;

        log.info("Start Game");
        log.info("This word have {} characters", count );

        while (count > 0 && life > 0) {
            log.info("You have {} life", life);
            log.info("Actual string: {}", game.getActualString());
            log.info("Please, enter character: ");

            if (game.containChar(scanner.next().charAt(0))){
                log.info("You are right!)");
                count = game.getCountClosedLetters();
            } else {
                log.info("Sorry, but word haven't this character(");
                log.info("You lost one life(");
                life--;
            }

        }

        log.info("Game End");

        if (life > 0){
            log.info("You are a winner!!! :)");
        } else{
            log.info("You are a loser :(");
        }
    }

    public static void main(String[] args) {
        start();
    }
}
