package com.alevel.nix.java.hometask.lesson5;

import java.util.Arrays;

public class TransposeArr {
    private int arr[][]={{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};

    public int[][] getArr() {
        return arr;
    }

    public void showArr(){
        for (int i = 0, length = arr.length; i < length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    public void transpose(){
        for (int i = 0, length = arr.length; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }
}
