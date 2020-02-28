package com.alevel.nix.java.hometask.lesson9;

public interface ITicTacToe {

    void newGame();

    boolean turn();

    boolean canTurn(int row, int col);

    boolean checkWin();

}
