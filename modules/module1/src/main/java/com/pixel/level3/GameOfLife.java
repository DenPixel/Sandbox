package com.pixel.level3;


public class GameOfLife {
    private Cell cells[][];

    GameOfLife(int m, int n){
        cells = new Cell[Math.abs(m)][Math.abs(n)];
        setLive();

    }

    private void setLive() {
        for (int i = 0, rowLength = cells.length; i < rowLength; i++) {
            for (int j = 0, colLength = cells[0].length; j < colLength; j++) {
                cells[i][j] = new Cell(Math.random() > 0.5);
            }
        }
    }

    public void showCells(){
        for (int i = 0, rowLength = cells.length; i < rowLength; i++) {
            for (int j = 0, colLength = cells[i].length; j < colLength; j++) {
                System.out.print((cells[i][j].isLive()? 1 : 0) + " ");
            }
            System.out.println();
        }
    }

    public void step(){
        for (int i = 0, rowLength = cells.length; i < rowLength; i++) {
            for (int j = 0, colLength = cells[i].length; j < colLength; j++) {
                int count = 0;

                if (i != 0 && j != 0 && cells[i-1][j-1].isLive()){
                    cells[i][j].setCLN(++count);
                }

                if (i != 0 &&cells[i-1][j].isLive()){
                    cells[i][j].setCLN(++count);
                }

                if (i != 0 && j != colLength-1 && cells[i-1][j+1].isLive()){
                    cells[i][j].setCLN(++count);
                }

                if (j != colLength-1 && cells[i][j+1].isLive()){
                    cells[i][j].setCLN(++count);
                }

                if (i != rowLength-1 && j != colLength-1 && cells[i+1][j+1].isLive()){
                    cells[i][j].setCLN(++count);
                }

                if (i != rowLength-1 && cells[i+1][j].isLive()){
                    cells[i][j].setCLN(++count);
                }

                if (i != rowLength-1 && j != 0 && cells[i+1][j-1].isLive()){
                    cells[i][j].setCLN(++count);
                }

                if (j != 0 && cells[i][j-1].isLive()){
                    cells[i][j].setCLN(++count);
                }
            }
        }

        for (int i = 0, rowLength = cells.length; i < rowLength; i++) {
            for (int j = 0, colLength = cells[i].length; j < colLength; j++) {
                if(cells[i][j].getCLN() < 2 || cells[i][j].getCLN() > 3){
                    cells[i][j].setLive(false);
                }else if (cells[i][j].getCLN() == 3){
                    cells[i][j].setLive(true);
                }
            }
        }
    }
}
