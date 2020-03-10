package com.alevel.nix.java.hometask.lesson14.practice;

public class ProgressionConfigurationException extends IllegalArgumentException {
    ProgressionConfigurationException () {
        throw new IllegalArgumentException();
    }
    ProgressionConfigurationException(String str){
        throw new IllegalArgumentException(str);
    }
}
