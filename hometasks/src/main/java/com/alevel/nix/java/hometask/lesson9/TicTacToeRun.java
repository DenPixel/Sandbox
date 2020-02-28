package com.alevel.nix.java.hometask.lesson9;

public class TicTacToeRun {
    public static void main(String[] args) {
        TicTacToeCtrl game = new TicTacToeCtrl(new TicTacToe3x3());
        game.newGame();
    }
}
