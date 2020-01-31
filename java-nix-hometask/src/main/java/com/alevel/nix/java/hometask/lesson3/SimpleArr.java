package com.alevel.nix.java.hometask.lesson3;

public class SimpleArr {
    protected int arr[];

    SimpleArr(int[] arr){
        this.arr = arr;
    }

    public void showArr(){
        for (int i = 0; i < this.arr.length; i++) {
            System.out.print(this.arr[i] + " ");
        }
        System.out.println();
    }

    public int[] getArr() {
        return arr;
    }
}
