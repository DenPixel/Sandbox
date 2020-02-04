package com.alevel.nix.java.hometask.lesson4;

public class FizzBuzz extends SimpleNumb {
    private String divisorStr;

    FizzBuzz(int numb){
        super(numb);
        fizzOrBuzz();
    }

    protected void fizzOrBuzz(){
        this.divisorStr = "";

        for (int fakeNumb = this.numb; fakeNumb != 0  ; fakeNumb /= 10, this.divisorStr += " ") {
            if ((fakeNumb % 10) % 2 == 0){
                this.divisorStr += "fizz";
            }
            if((fakeNumb % 10) % 3 == 0){
                this.divisorStr += "buzz";
            }
        }
    }

    public String getDivisorStr() {
        return divisorStr;
    }
}
