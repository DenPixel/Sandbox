package com.alevel.nix.java.hometask.lesson3;

public class SimpleFindMaxAndMinFromArr extends SimpleArr {

    SimpleFindMaxAndMinFromArr(int[] arr){
        super(arr);
    }

    public int getMaxNumbFromArr(){
        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] > max){ max = arr[i]; }
            max = arr[i] > max ? arr[i] : max;
        }

        return max;
    }

    public int getMinNumbFromArr(){
        int min = arr[0] ;

        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] < min){ min = arr[i]; }
            min = arr[i] < min ? arr[i] : min;
        }

        return min;
    }

}
