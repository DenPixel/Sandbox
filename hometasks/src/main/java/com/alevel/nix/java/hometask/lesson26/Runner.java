package com.alevel.nix.java.hometask.lesson26;

import java.util.List;

public class Runner{
    public static void main(String[] args) {
        CSVMapper csvMapper = new CSVMapper();
        List<PersonalData> all = csvMapper.createAll(
                "hometasks/src/main/java/com/alevel/nix/java/hometask/lesson26/personalData.csv",
                PersonalData.class
        );

        all.forEach(System.out::println);

    }
}
