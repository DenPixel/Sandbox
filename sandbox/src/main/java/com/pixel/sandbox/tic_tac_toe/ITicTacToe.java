package com.pixel.sandbox.tic_tac_toe;

public interface ITicTacToe {

    void newGame();

    boolean turn();

    boolean canTurn(int row, int col);

    boolean checkWin();

}
