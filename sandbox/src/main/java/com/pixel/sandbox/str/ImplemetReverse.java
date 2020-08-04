package com.pixel.sandbox.str;

public class ImplemetReverse {

    public CharSequence reverse(CharSequence str){
        StringBuilder sub = new StringBuilder((str));
        return sub.reverse().toString();
    }
}
