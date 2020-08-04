package com.pixel.sandbox.arrays;

public class TeslaStocks {
    private double stocks[] = new double[7], profit = 0;
    private int firstDay, secondDay;

    TeslaStocks(){
        setActions();
        maxProfit();
    }

    private void setActions() {
        for (int i = 0, length = stocks.length; i < length; i++) {
            stocks[i] =(double) Math.round(Math.random() * 10000) /100 ;
        }
    }

    private void maxProfit(){
        int length = stocks.length;
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                if(stocks[i] < stocks[j] && (stocks[j] - stocks[i]) > profit){
                    profit = (double) Math.round((stocks[j] - stocks[i]) * 100) /100;
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

    public double[] getStocks() {
        return stocks;
    }
}
