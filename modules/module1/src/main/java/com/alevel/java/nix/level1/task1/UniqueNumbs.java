package com.alevel.java.nix.level1.task1;

import java.util.HashSet;

public class UniqueNumbs {
    public int countUniqueNumbs(int ... numbs){
        if (numbs.length < 2){
            return numbs.length;
        }

        HashSet<Integer> uniqueNumbs = new HashSet<>();

        for (int numb : numbs) {
            uniqueNumbs.add(numb);
        }

        return uniqueNumbs.size();
    }
}
