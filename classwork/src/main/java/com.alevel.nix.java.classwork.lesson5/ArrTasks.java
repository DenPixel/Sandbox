package com.alevel.nix.java.classwork.lesson5;

public class ArrTasks {
    private int arr[];

    private void toSwap(int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    ArrTasks(int ... arr){
        setArr(arr);
    }

    public void setArr(int... arr) {
        this.arr = arr;
    }

    public int summElK(int k){
        int result = 0;
        for (int i : this.arr) {
            if((i % k) == 0) {
                result += i;
            }
        }
        return result;
    }

    public int[] getArrOfIndexEl(){
        int newArr[], count = 0;
        for (int i : this.arr) {
            if(i==0){
                count++;
            }
        }

        newArr = new int[count];
        count = 0;
        for (int i = 0, length = arr.length; i < length; i++) {
            if(arr[i] == 0){
                newArr[count++] = arr[i];
            }
        }

        return newArr;
    }

    public void firstNumbPosOrNeg(){
        String str = "First number is ";
        if(arr[0] == 0){
            str += 0;
        }else
        if(arr[0] > 0){
            str += "postive";
        }else{
            str += "negative";
        }
        System.out.println(str);
    }

    public void numbsAreIncr(){
        String str = "Numbers are ";
        boolean inc = true;
        for (int i = 0, length = arr.length - 1; i < length; i++) {
            if(arr[i] > arr[i+1]){
                str += " not increasing";
                inc = false;
                break;
            }
        }
        if(inc){
            str += "increasing";
        }
        System.out.println(str);
    }

    public int[] getArrEvenNumbs(){
        int newArr[], count = 0;

        for (int i : this.arr) {
            if((i % 2) == 0){
                count++;
            }
        }

        if(count == 0){
            System.out.println("No even numbers");
            return null;
        }

        newArr = new int[count];
        count = 0;
        for (int i = 0, length = arr.length; i < length; i++) {
            if((arr[i] % 2) == 0){
                newArr[count++] = arr[i];
            }
        }

        return newArr;
    }

    public int minNumb(){
        int min = arr[0];

        for (int i = 1, length = arr.length; i < length; i++) {
            min = arr[i] < min ? arr[i] : min;
        }

        return min;
    }

    public void reNumbsZ(int z){
        int count = 0;
        for (int i = 0, length =  arr.length; i < length; i++) {
            if(arr[i] > z){
                arr[i] = z;
                count++;
            }
        }
    }

    public void toCountPosNegZe(){
        int countPos = 0, countNeg = 0, countZe = 0;
        for (int i : arr) {
            if(i == 0){
                countZe++;
            }else
            if(i > 0){
                countPos++;
            }else{
                countNeg++;
            }
        }

        System.out.println("Count positive numbers = " + countPos);
        System.out.println("Count negative numbers = " + countNeg);
        System.out.println("Count 0 numbers = " + countZe);
    }

    public void toSwapMinAndMax(){
        int maxInd = 0, minInd = 0;
        for (int i = 1, max = arr[0], min = arr[0]; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
                maxInd = i;
            }
            if (arr[i] < min){
                min = arr[i];
                minInd = i;
            }
        }

        toSwap(minInd,maxInd);

    }
}
