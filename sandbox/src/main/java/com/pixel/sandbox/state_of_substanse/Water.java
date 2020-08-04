package com.pixel.sandbox.state_of_substanse;

public class Water implements Substance{
    private double temperature = 20;

    private void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public State heatUp(double temperature) {
        setTemperature(temperature);
        if (temperature <= 0) {
            return State.SOLID;
        } else if (temperature >=100) {
            return State.GAS;
        } else {
            return State.LIQUID;
        }
    }

    @Override
    public double getTemperature() {
        return temperature;
    }
}
