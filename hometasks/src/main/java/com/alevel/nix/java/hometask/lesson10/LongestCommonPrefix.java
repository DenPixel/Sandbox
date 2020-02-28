package com.alevel.nix.java.hometask.lesson10;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String ... strs){
        int length = strs.length;

        if (length < 1){
            return "";
        }

        StringBuilder prefix = new StringBuilder(strs[0]);

        int lengthPre = prefix.length();

        for (int i = 1; i < length; i++) {
            if (lengthPre > strs[i].length()){
                lengthPre = strs[i].length();
            }

            for (int j = 0 ; j < lengthPre; j++) {
                if(prefix.charAt(j) == strs[i].charAt(j)){
                    continue;
                }
                lengthPre = j;
                break;
            }
        }

        prefix.delete(lengthPre,prefix.length());

        return prefix.toString();
    }
}
