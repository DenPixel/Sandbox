package com.alevel.nix.java.hometask.lesson16;

import java.util.*;
import java.util.stream.Collectors;


public class NumbFromStrs {

    public int getNumbFromStrs (String ... strs) {
        Objects.requireNonNull(strs);

//        System.out.println(Arrays.stream(strs).count());
//
//        for (String str : strs) {
//            int[] i = str.chars()
//                    .mapToObj(c -> (char) c)
//                    .filter(Character::isDigit)
//                    .mapToInt( ic -> Integer.parseInt(Character.toString(ic)))
//                    .toArray();
//            System.out.println(i[0]);
//        }

        List<Integer> ff = new ArrayList<>();

        for (String str : strs) {
            List <Integer> ss =str.chars()
                    .boxed()
                    .filter(Character::isDigit)
                    .collect(Collectors.toList());
            ff.addAll(ss);
        }

        System.out.println(ff);


//        char[] list= Arrays.stream(strs)
//                .filter(Objects::nonNull)
//                .map(String::chars)
//                .filter(i -> Character.isDigit(Character.))
//
//
//        for (String[] strings : list) {
//            System.out.println(Arrays.toString(strings));
//        }

//        for (String s : strv) {
//            System.out.println(s);
//
//        }


//        Arrays.stream(strs).ma
        return 0;
    }
}
