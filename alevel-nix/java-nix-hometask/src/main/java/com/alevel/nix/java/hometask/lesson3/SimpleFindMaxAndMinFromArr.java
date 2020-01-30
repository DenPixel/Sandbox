package com.alevel.nix.java.hometask.lesson3;

public class SimpleFindMaxAndMinFromArr extends SimpleArr {

    public int getMaxNumbFromArr(){
        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] > max){ max = arr[i]; }
            max = arr[i] > max ? arr[i] : max;
        }

        return max;
    }

    public int getMaxNumbFromArr(int[] arr){
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

    public int getMinNumbFromArr(int[] arr){
        int min = arr[0] ;

        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] < min){ min = arr[i]; }
            min = arr[i] < min ? arr[i] : min;
        }

        return min;
    }

    public void showArr(){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void showArr(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
