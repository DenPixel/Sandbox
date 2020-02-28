package com.alevel.java.nix.level1.task2;

public class StepHorse {

    public boolean canHorseStep(int startX, int startY, int finishX, int finishY){

        if ((finishX == startX+2 || finishX == startX-2)
                && (finishY == startY+1 || finishY == startY-1)){
            return true;

        }else if ((finishX == startX+1 || finishX == startX-1)
                && (finishY == startY+2 || finishY == startY-2)){
            return true;

        }else{
            return false;
        }
    }

}
