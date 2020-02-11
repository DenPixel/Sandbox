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

        for (int i = 0; i < length; i += (numRows - 1) * 2) {
            newStr += str.charAt(i);
        }

        for (int i = 1; i < numRows - 1; i++) {

            for (int j = i; j < length; j += (numRows - i - 1) * 2 ) {

                if(){
                    newStr += str.charAt(j);
                }else{
                    newStr += str.charAt(j + (numRows - i - 1));
                }

            }

        }

        for (int i = numRows - 1 ; i < length; i += (numRows - 1) * 2) {
            newStr += str.charAt(i);
        }
    }


    public String getNewStr() {
        return newStr;
    }
}
