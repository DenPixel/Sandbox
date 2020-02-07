package com.alevel.nix.java.hometask.lesson5;

public class TeslaActions {
    private double actions[] = new double[7], profit = 0;
    private int firstDay, secondDay;

    TeslaActions(){
        setActions();
        maxProfit();
    }

    private void setActions() {
        for (int i = 0, length = actions.length; i < length; i++) {
            actions[i] = Math.round(Math.random() * 10000) /100 ;
        }
    }

    private void maxProfit(){
        int length = actions.length;
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                if(actions[i] < actions[j] && (actions[j] - actions[j]) > profit){
                    profit = actions[j] - actions[j];
                    secondDay = j;
                    firstDay = i;
                }
            }
        }

    }

    public void messageProfit(){
        System.out.println("Max profit = " + profit);
        System.out.println("Day of purchase = " + firstDay);
        System.out.println("Day of sale = " + secondDay);
    }

}
