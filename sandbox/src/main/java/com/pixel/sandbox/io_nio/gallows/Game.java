package com.pixel.sandbox.io_nio.gallows;

public class Game {
    public static void main(String[] args) {
        GameLoop game = new GameLoop(Gallows.build());
        game.start();
    }
}
