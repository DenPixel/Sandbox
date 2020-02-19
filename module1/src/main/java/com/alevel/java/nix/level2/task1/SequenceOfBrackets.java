package com.alevel.java.nix.level2.task1;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

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

        if(length == 0){
            return true;
        }

        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < length; i++) {
            if(chars.containsKey(str.charAt(i))){
                stack.push(str.charAt(i));
            }else if(chars.containsValue(str.charAt(i)) && !stack.isEmpty() &&
                    chars.get(stack.pollLast()) != str.charAt(i)){
                return false;
            }
        }

        if(!stack.isEmpty()){
            return false;
        }

        return true;
    }


    /* реализация Миши
    public boolean validate(String s) {
        if (s.isEmpty()) return true;

        var stack = new ArrayDeque<Character>();

        for (int i = 0, length = s.length(); i < length; i++) {
            char current = s.charAt(i);
            switch (current) {
                case '{':
                case '[':
                case '(':
                    stack.push(current);
                    break;
                case ']':
                    if (stack.isEmpty() || stack.poll() != '[') return false;
                    break;
                case '}':
                    if (stack.isEmpty() || stack.poll() != '{') return false;
                    break;
                case ')':
                    if (stack.isEmpty() || stack.poll() != '(') return false;
                    break;
            }
        }

        return stack.isEmpty();
    }
     */
}
