package com.alevel.nix.java.hometask.lesson4;

public class SimpleQuantityBits extends SimpleNumb{
    private int quantityBits = 0;

    SimpleQuantityBits(int numb){
        super(numb);
        toCountQuantityBits();
    }

    private void toCountQuantityBits(){
        for (int fakeNumb = this.numb; fakeNumb != 0; fakeNumb /= 2) {
            if((fakeNumb % 2) == 1){
                quantityBits++;
            }
        }
    }

    public int getQuantityBits() {
        return quantityBits;
    }
}
