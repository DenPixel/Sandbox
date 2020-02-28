package com.alevel.nix.java.hometask.lesson9;

public class TicTacToeCtrl {
    private final ITicTacToe model;

    TicTacToeCtrl(ITicTacToe model){
        this.model = model;
    }

    void newGame(){
        model.newGame();
    }
}
