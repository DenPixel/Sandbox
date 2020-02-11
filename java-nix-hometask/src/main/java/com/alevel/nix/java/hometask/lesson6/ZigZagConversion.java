package com.alevel.nix.java.hometask.lesson6;

public class ZigZagConversion {
    private String str, newStr = "";
    private int numRows;

    ZigZagConversion(String str, int numRows){
        this.str = str;
        this.numRows = numRows;
        toZigZag();
    }

    private void toZigZag(){
        int length = str.length();

        if(numRows <= 1){
            newStr = str;
            return;
        }

        for (int i = 0; i < length; i += (numRows - 1) * 2) {
            newStr += str.charAt(i);
        }

        for (int i = 1; i < numRows - 1; i++) {
            boolean alternate = false;
            for (int j = i; j < length;) {
                newStr += str.charAt(j);
                if(alternate){
                    j += i * 2;
                }else{
                    j += (numRows - i - 1) * 2;
                }
                alternate = !alternate;
            }
        }

        for (int i = numRows - 1 ; i < length; i += (numRows - 1) * 2) {
            newStr += str.charAt(i);
        }

        System.out.println(newStr);
    }


    public String getNewStr() {
        return newStr;
    }
}
