package com.alevel.java.nix.level2.task1;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class SequenceOfBrackets {
    private final char VALID_CHARS[] = {'(', ')', '{', '}', '[', ']'};
    private Map<Character, Character> chars = new HashMap<Character, Character>();

    SequenceOfBrackets(){
        for (int i = 0; i < VALID_CHARS.length - 1; i+=2) {
            chars.put(VALID_CHARS[i],VALID_CHARS[i+1]);
        }
    }

    public boolean isLineValid(String str){
        int length = str.length();
        Vector key = new Vector();

        if(length == 0){
            return true;
        }else if (length % 2 != 0){
            return false;
        }

        for (int i = 0; i < length; i++) {
//            if(!chars.containsKey(str.charAt(i)) || !chars.containsValue(i)){
//                return false;
//            }

            if(chars.containsKey(str.charAt(i))){
                key.add(str.charAt(i));
            }else if(chars.containsValue(str.charAt(i)) && chars.get(key.lastElement()) == str.charAt(i)){
                key.remove(key.size()-1);
            }else {
                return false;
            }

        }
        return true;
    }
}
