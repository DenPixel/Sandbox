package com.pixel.sandbox.streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Palindromic {

    private boolean isPalindromic(String str){
        int start = 0, end = 0;

        while (start < end){
            if(str.charAt(start++) != str.charAt(end++)){
                return false;
            }
        }
        return true;
    }

    public List<String> findPalindromicWords(Collection<String> strs){
        return strs.stream()
                .flatMap(s -> Arrays.stream(s.split(" ")))
                .filter(this::isPalindromic)
                .collect(Collectors.toList());
    }
}
