package com.pixel.sandbox.state_of_substanse;

public class LoopRunner {
    public static void main(String[] args) {
        SubstanceLoop sl = new SubstanceLoop(new Water());
        sl.runLoop();
    }
}
