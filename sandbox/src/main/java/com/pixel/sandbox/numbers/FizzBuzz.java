package com.pixel.sandbox.numbers;

public class FizzBuzz{
    private String divisorStr;
    protected int numb;

    private void setNumb(int numb) {
        this.numb = numb;
    }

    FizzBuzz(int numb){
        setNumb(numb);
        fizzOrBuzz();
    }

    private void fizzOrBuzz(){
        this.divisorStr = "";

        if(this.numb == 0){
            this.divisorStr += this.numb;
            return;
        }

        for (int fakeNumb = this.numb < 0 ? -this.numb : this.numb;
             fakeNumb != 0  ;
             fakeNumb /= 10, this.divisorStr += " ") {

            if ((fakeNumb % 10) % 2 == 0){
                this.divisorStr += "fizz";
            }
            if((fakeNumb % 10) % 3 == 0){
                this.divisorStr += "buzz";
            }else
            if((fakeNumb % 10) % 2 != 0 && (fakeNumb % 10) % 3 != 0){
                this.divisorStr += fakeNumb % 10;
            }
        }
    }

    public String getDivisorStr() {
        return divisorStr;
    }
}
