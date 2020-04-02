package com.alevel.nix.java.hometask.lesson19.practice;

import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Task3 {

    public List<String> subStr(Collection<String> list, Pattern pattern){
        return list.stream()
                .map(s -> pattern.matcher(s).replaceAll(""))
                .collect(Collectors.toList());
    }
}
