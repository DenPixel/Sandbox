package com.alevel.nix.java.hometask.lesson9;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToeClassic {
    private final static Logger log = LoggerFactory.getLogger(TicTacToeClassic.class);
    private byte countStep = 0, sizeGrid = 3;
    private char grid[][] = new char[sizeGrid][sizeGrid];
    private String winer = "";

    TicTacToeClassic(){
        for (byte i = 0; i < sizeGrid; i++) {
            Arrays.fill(grid[i],' ');
        }
    }

    public void startGame(){
        if (winer != ""){
            log.info("You need to start new game");
            return;
        }

        log.info("Start game");
        while (winer == ""){
            progress();
            log.info("Player {} step", countStep % 2 == 0 ? 'x':'0');
            step();
        }

        progress();
        log.info("Finish game");
        getWiner();
    }

    public void newGame(){
        for (byte i = 0; i < sizeGrid; i++) {
            Arrays.fill(grid[i],' ');
        }
        countStep = 0;
        winer = "";

        startGame();
    }

    public boolean step(){
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();

        if(!canStep(--row,--col)){
            log.info("Player can't step");
            return false;
        }

        grid[row][col] = countStep++ % 2 == 0 ? 'x' : '0';

        if (countStep > 5){
            checkWin();
        }

        log.info("Player stepped");
        return true;
    }

    public boolean canStep(int row, int col){
        if (row > sizeGrid - 1 || row < 0 || col > sizeGrid - 1 || col < 0){
            return false;
        }

        if (countStep >= 9){
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

    public boolean checkWin(){
        byte center = 1;

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

        if (countStep >= 9){
            winer += "x0";
        }

        return false;
    }

    public String getWiner() {
        log.info("Winer {}", winer);
        return winer;
    }

    public void progress(){
        for (byte i = 0; i < sizeGrid; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }
    }

}


