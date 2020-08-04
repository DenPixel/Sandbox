package com.pixel.sandbox.tic_tac_toe;

public class TicTacToeRun {
    public static void main(String[] args) {
        TicTacToeCtrl game = new TicTacToeCtrl(new TicTacToe3x3());
        game.newGame();
    }
}
