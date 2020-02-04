package com.alevel.nix.java.hometask.lesson4;

public class FizzBuzz {
    private int numb;
    private String divisorStr;

    FizzBuzz(int numb){
        setNumb(numb);
        fizzOrBuzz();
    }

    private void setNumb(int numb) {
        this.numb = numb;
    }

    protected void fizzOrBuzz(){
        this.divisorStr = "";

        for (int fakeNumb = this.numb; fakeNumb > 0  ; fakeNumb /= 10) {
            if ((fakeNumb % 10) % 2 == 0){
                this.divisorStr += "fizz";
            }
            if((fakeNumb % 10) % 3 == 0){
                this.divisorStr += "buzz";
            }
            this.divisorStr += " ";
        }
    }

    public String getDivisorStr() {
        return divisorStr;
    }
}
