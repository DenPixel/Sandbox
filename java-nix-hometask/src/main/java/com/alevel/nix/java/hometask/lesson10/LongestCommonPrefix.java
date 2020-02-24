package com.alevel.nix.java.hometask.lesson10;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String ... strs){
        int length = strs.length;

        if (length < 1){
            return "";
        }

        StringBuilder prefix = new StringBuilder(strs[0]);


        for (int i = 1; i < length; i++) {

            int lengthPre;
            if (prefix.length() > strs[i].length()){
                lengthPre = strs[i].length();
                prefix.delete(lengthPre,prefix.length());
            }else {
                lengthPre = prefix.length();
            }

            for (int j = lengthPre-1 ; j >= 0; j--) {
                if(prefix.charAt(j) != strs[i].charAt(j)){
                    prefix.delete(j,lengthPre);
                }
            }
        }
        return prefix.toString();
    }
}
