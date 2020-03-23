package com.alevel.nix.java.hometask.lesson18;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;


public class Homework {


    public List<String> stringWithSubString(String path, String subString) throws IOException {

        return Files.lines(Paths.get(path))
                .filter(s -> s.contains(subString))
                .collect(Collectors.toList());

    }

    public static void main(String[] args) {
        Homework h = new Homework();
        try {
            System.out.println(h.stringWithSubString("hometasks/src/main/java/com/alevel/nix/java/hometask/lesson18/n.txt", "world"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
