package com.pixel.sandbox.state_of_substanse;

public class Iron implements Substance {
    private double temperature = 20;

    private void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public State heatUp(double temperature) {
        setTemperature(temperature);
        if (temperature < 1538) {
            return State.SOLID;
        } else if (temperature < 2861) {
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
