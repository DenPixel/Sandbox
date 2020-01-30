package com.alevel.nix.java.hometask.lesson3;

public class BubbleSort extends SimpleArr {

    BubbleSort(int[] arr) {
        super(arr);
    }

    public void sort(){
        for (int i = 0; i < this.arr.length; i++) {
            for (int j = 0; j < this.arr.length - i; j++) {
                if (arr[j] < arr[j+1]){
                    swap( j,j+1);
                }
            }
        }
    }

    private void swap(int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
