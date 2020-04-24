package com.alevel.nix.java.hometask.lesson26;

import java.util.List;

public class Runner{
    public static void main(String[] args) {
        if (args.length <= 0) return;

        CSVMapper csvMapper = new CSVMapper();

        List<PersonalData> all = csvMapper.createAll(
                args[0],
                PersonalData.class
        );

        all.forEach(System.out::println);

    }
}
