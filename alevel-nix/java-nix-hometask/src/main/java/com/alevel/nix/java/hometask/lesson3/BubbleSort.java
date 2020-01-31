package com.alevel.nix.java.hometask.lesson3;

public class BubbleSort extends SimpleArr {

    BubbleSort(int[] arr) {
        super(arr);
    }

    public void sortSmallToLarge(){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j+1]){
                    swap( j,j+1);
                }
            }
        }
    }

    public void sortLargeToSmall(){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] < arr[j+1]){
                    swap( j ,  j+1);
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
