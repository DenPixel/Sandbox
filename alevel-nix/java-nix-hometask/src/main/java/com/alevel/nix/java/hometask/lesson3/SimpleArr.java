package com.alevel.nix.java.hometask.lesson3;

public class SimpleArr {
    protected int arr[];

    SimpleArr(){
        int leghtArr = (int) (Math.random() * 100);
        arr = new int[leghtArr];
    }
    SimpleArr(int[] arr){
        this.arr = arr;
    }
}
