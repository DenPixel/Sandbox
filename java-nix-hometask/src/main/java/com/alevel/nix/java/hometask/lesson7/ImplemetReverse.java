package com.alevel.nix.java.hometask.lesson7;

public class ImplemetReverse {

    public CharSequence reverse(CharSequence str){
        StringBuilder sub = new StringBuilder((str));
        return sub.reverse().toString();
    }
}
