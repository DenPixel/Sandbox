package com.alevel.nix.java.hometask.lesson25;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
public @interface PropertyKey {
    String name();
}
