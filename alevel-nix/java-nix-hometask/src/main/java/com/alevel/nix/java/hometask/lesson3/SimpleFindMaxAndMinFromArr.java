package com.alevel.nix.java.hometask.lesson3;

public class SimpleFindMaxAndMinFromArr extends SimpleArr {
    private int max, min;

    SimpleFindMaxAndMinFromArr(int[] arr){
        super(arr);
        setMaxAndMinNumbFromArr();
    }

    private void setMaxAndMinNumbFromArr(){
        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] > max){ max = arr[i]; }
//            if (arr[i] < min){ min = arr[i]; }
            max = arr[i] > max ? arr[i] : max;
            min = arr[i] < min ? arr[i] : min;
        }

    }

    public int getMax() {
        return max;
    }

    public int getMin(){
        return min;
    }


}
