package com.pixel.jdbcbox;

public class Runner {
    public static void main(String[] args) {
        Network network = Network.build();
        network.searchMinWayCosts();
    }
}
