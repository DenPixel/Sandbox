package com.alevel.nix.java.hometask.lesson21;

public class Game {
    public static void main(String[] args) {
        GameLoop game = new GameLoop(Gallows.build());
        game.start();
    }
}
