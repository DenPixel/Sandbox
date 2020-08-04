package com.pixel.sandbox.io_nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CharFrequency {
//    public Map<Character, Integer> frequency(String path) throws IOException {
//        Files.lines(Paths.get(path))
//                .flatMap(s -> Arrays.stream(s.split("")))
//                .map(s -> s.charAt(0))
//                .collect(c -> Collectors.groupingBy(
//                        c,
//                        () -> new Enum<>(CharFrequency.class),
//                        Collectors.summingInt(o -> 1)
//                ));
//    }

    public Map<Character, Integer> frequency(String path) throws IOException {
        var str = Files.readString(Paths.get(path));

        Map<Character, Integer> frequency = new HashMap<>();

        for (int i = 0, length = str.length(); i < length; i++) {
            frequency.merge(str.charAt(i),1, Integer::sum);
        }

        return frequency;
    }

}
