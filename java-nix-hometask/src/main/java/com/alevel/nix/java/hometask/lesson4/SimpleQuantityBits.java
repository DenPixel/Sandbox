package com.alevel.nix.java.hometask.lesson4;

public class SimpleQuantityBits{
    private int quantityBits = 0;
    protected long numb;

    private void setNumb(long numb) {
        this.numb = numb;
    }

    SimpleQuantityBits(long numb){
        setNumb(numb);
        toCountQuantityBits();
    }

    private void toCountQuantityBits(){
        for (long fakeNumb = this.numb < 0 ? -this.numb : this.numb;
             fakeNumb != 0;
             fakeNumb /= 2)
        {
            if((fakeNumb % 2) == 1){
                quantityBits++;
            }
        }
        if (this.numb < 0){
            quantityBits = 64 - quantityBits;
        }
    }

    public int getQuantityBits() {
        return quantityBits;
    }
}
