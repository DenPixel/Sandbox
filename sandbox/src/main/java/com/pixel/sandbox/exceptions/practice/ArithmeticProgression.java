package com.pixel.sandbox.exceptions.practice;

public class ArithmeticProgression {
    private final int inital, step;

    ArithmeticProgression (int inital, int step) throws ProgressionConfigurationException {
        if (step == 0){
            throw new ProgressionConfigurationException("step can't = 0");
        }
        this.step = step;
        this.inital = inital;

    }

    int calculation (int n) throws ProgressionConfigurationException{
        if (n<=0){
            throw new ProgressionConfigurationException("n have to > 0");
        }

        return inital + step * (n-1);
    }


}
