package com.alevel.nix.java.hometask.lesson26;

import java.lang.reflect.Field;

@FunctionalInterface
public interface Block {
    void run(Object target, Field field, String prop) throws IllegalAccessException;
}
