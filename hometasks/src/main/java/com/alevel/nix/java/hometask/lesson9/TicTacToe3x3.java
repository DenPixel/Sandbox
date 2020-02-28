package com.alevel.nix.java.hometask.lesson9;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe3x3 implements ITicTacToe {
    private final static Logger log = LoggerFactory.getLogger(TicTacToe3x3.class);
    private int countTurn = 0, sizeGrid = 3;
    private char grid[][] = new char[sizeGrid][sizeGrid];
    private String winer = "";


    @Override
    public void newGame(){
        for (int i = 0; i < sizeGrid; i++) {
            Arrays.fill(grid[i],' ');
        }
        countTurn = 0;
        winer = "";

        log.info("Start game");

        while (winer == ""){
            progress();
            log.info("Player {} step", countTurn % 2 == 0 ? 'x':'0');
            turn();
        }

        progress();
        log.info("Finish game");
        getWiner();
    }



    @Override
    public boolean turn(){
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();

        if(!canTurn(row,col)){
            log.info("Player can't step");
            return false;
        }

        grid[row][col] = countTurn++ % 2 == 0 ? 'x' : '0';

        if (countTurn > 5){
            checkWin();
        }

        log.info("Player stepped on row #{} and col #{}", row, col);
        return true;
    }

    @Override
    public boolean canTurn(int row, int col){
        if (row > sizeGrid - 1 || row < 0 || col > sizeGrid - 1 || col < 0){
            return false;
        }

        if (countTurn >= 9){
            return false;
        }

        if(grid[row][col] != ' '){
            return false;
        }

        if (winer != ""){
            return false;
        }

        return true;
    }

    @Override
    public boolean checkWin(){
        int center = 1;

        for (int i = 0; i < sizeGrid; i++) {
            char centerRow = grid[center][i], centerCol = grid[i][center];
            if (centerRow != ' ' &&
                    centerRow == grid[0][i] &&
                    centerRow == grid[sizeGrid-1][i]){
                winer += centerRow;
                return true;
            }

            if (centerCol != ' ' &&
                    centerCol == grid[i][0] &&
                    centerCol == grid[i][sizeGrid-1]){
                winer += centerCol;
                return true;
            }
        }

        if (grid[center][center] != ' '){
            char cc = grid[center][center];
            if ((cc == grid[0][sizeGrid-1] && cc == grid[sizeGrid-1][0]) ||
                    (cc == grid[0][0] && cc == grid[sizeGrid-1][sizeGrid-1])){
                winer += cc;
                return true;
            }
        }

        if (countTurn >= 9){
            winer += "x0";
        }

        return false;
    }

    public String getWiner() {
        log.info("Winer {}", winer);
        return winer;
    }

    public void progress(){
        for (int i = 0; i < sizeGrid; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }
    }

}


