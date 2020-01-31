package com.alevel.nix.java.hometask.lesson3;

public class BubbleSort extends SimpleArr {

    BubbleSort(int[] arr) {
        super(arr);
    }

    public void sortSmallToLarge(){
        for (int i = 0; i < this.arr.length; i++) {
            for (int j = 0; j < this.arr.length; j++) {
                if (arr[j] < arr[j+1]){
                    swap( j,j+1);
                }
            }
        }
    }

    public void sortLargeToSmall(){
        for (int i = this.arr.length - 1; i > 0; i--) {
            for (int j = this.arr.length - 1; j > 0; j--) {
                if (arr[j - 1] > arr[j]){
                    swap( j -1 ,j);
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
