package com.pixel.level3;

public class Cell {
    private boolean live;
    private int countLiveNeighbours;

    Cell(boolean live){
        this.live = live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    //setCountLiveNeighbours
    public void setCLN(int countLiveNeighbours) {
        this.countLiveNeighbours = countLiveNeighbours;
    }

    //getCountLiveNeighbours
    public int getCLN() {
        return countLiveNeighbours;
    }

    public boolean isLive() {
        return live;
    }
}
