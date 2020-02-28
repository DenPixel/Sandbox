package com.alevel.nix.java.hometask.lesson6;

import java.util.HashMap;

public class LongestSubstring {
    private String subStr;
    HashMap<Integer, Character> keyChar = new HashMap<Integer, Character>();
    private int countRepeatChar;

    LongestSubstring(String subStr){
        this.subStr = subStr;
        this.countRepeatChar = toCountRepeatChar();
    }

    private int toCountRepeatChar(){
        int lengthStr = subStr.length();

        for (int i = 0; i < lengthStr; i++) {
            if(!this.keyChar.containsKey(this.subStr.charAt(i))){
                this.keyChar.put((int) this.subStr.charAt(i), this.subStr.charAt(i));
            }
        }

        return this.keyChar.size();
    }

    public int getCountRepeatChar() {
        return countRepeatChar;
    }
}
