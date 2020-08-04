package com.pixel.sandbox.tic_tac_toe;

public class TicTacToeCtrl {
    private final ITicTacToe model;

    TicTacToeCtrl(ITicTacToe model){
        this.model = model;
    }

    void newGame(){
        model.newGame();
    }
}
