package com.pixel.sandbox.arrays;

public class ContainerWithMostWater {
    private int arr[], containerArea = 0;

    ContainerWithMostWater(int ... arr){
        this.arr = arr;
        area();
    }

    private void area(){
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j > i; j--) {
                if(arr[i] < 0 || arr[j]<0){
                    continue;
                }

                int iterArea = (j - i) * (arr[i] < arr[j] ? arr[i] : arr[j]);

                if (containerArea < iterArea){
                    containerArea = iterArea;
                }
            }
        }
    }

    public int getContainerArea() {
        return containerArea;
    }
}
