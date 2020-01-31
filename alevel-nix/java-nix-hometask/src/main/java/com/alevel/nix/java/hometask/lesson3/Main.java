package com.alevel.nix.java.hometask.lesson3;

public class Main {
    public static void main(String[] args) {
        int arr[] = {15, 5, 6, 1};
        BubbleSort bubbleSort = new BubbleSort(arr);
        bubbleSort.sortSmallToLarge();
        bubbleSort.showArr();
    }
}
