package com.alevel.java.nix.level1.task1;

import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class UniqueNumbs {
    public int countUniqueNumbs(int ... numbs){
        if (numbs.length < 2){
            return numbs.length;
        }

        HashSet<Integer> unigueNumbs = new HashSet<>();

        for (int numb : numbs) {
            if (!unigueNumbs.contains(numb)){
                unigueNumbs.add(numb);
            }
        }

        return unigueNumbs.size();
    }
}
