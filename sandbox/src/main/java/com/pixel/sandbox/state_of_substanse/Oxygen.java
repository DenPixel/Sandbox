package com.pixel.sandbox.state_of_substanse;

public class Oxygen implements Substance {
    private double temperature = 20;

    private void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public State heatUp(double temperature) {
        setTemperature(temperature);
        if (temperature < -218.35){
            return State.SOLID;
        } else if (temperature < -182.98) {
            return State.LIQUID;
        } else {
            return State.GAS;
        }
    }

    @Override
    public double getTemperature() {
        return temperature;
    }
}
