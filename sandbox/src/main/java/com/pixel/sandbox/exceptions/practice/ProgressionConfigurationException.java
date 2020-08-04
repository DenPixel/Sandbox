package com.pixel.sandbox.exceptions.practice;

public class ProgressionConfigurationException extends IllegalArgumentException {
    ProgressionConfigurationException () {
        throw new IllegalArgumentException();
    }
    ProgressionConfigurationException(String str){
        throw new IllegalArgumentException(str);
    }
}
