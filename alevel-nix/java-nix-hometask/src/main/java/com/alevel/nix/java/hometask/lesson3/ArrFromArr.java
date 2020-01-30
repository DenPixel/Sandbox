package com.alevel.nix.java.hometask.lesson3;

public class ArrFromArr extends SimpleArr {
    private int k, newArr[];

    ArrFromArr(int[] arr, int multipleNumb) {
        super(arr);
        k = multipleNumb;
        numbOfMultipleAndNewArrSize();
        setNewArr();
    }

    private void numbOfMultipleAndNewArrSize(){
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if ( (arr[i] % k) == 0 ){
                count++;
            }
        }
        newArr = new int[count];
    }

    private void setNewArr(){
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if ( (arr[i] % k) == 0 ){
                newArr[count] = arr[i];
                count++;
            }
        }
    }




}