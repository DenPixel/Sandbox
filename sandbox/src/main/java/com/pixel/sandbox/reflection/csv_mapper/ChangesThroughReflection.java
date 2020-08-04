package com.pixel.sandbox.reflection.csv_mapper;

import java.lang.reflect.Field;

@FunctionalInterface
public interface ChangesThroughReflection {
    void run(Object target, Field field, String prop) throws IllegalAccessException;
}
