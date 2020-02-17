package com.alevel.java.nix.level1.task1;

import java.util.Map;
import java.util.HashMap;

public class UniqueNumbs {
    public int countUniqueNumbs(int ... numbs){
        if (numbs.length < 2){
            return numbs.length;
        }

        Map<Integer, Integer> unigueNumbs = new HashMap<>();

        for (int numb : numbs) {
            if (!unigueNumbs.containsKey(numb)){
                unigueNumbs.put(numb, numb);
            }
        }

        return unigueNumbs.size();
    }
}
