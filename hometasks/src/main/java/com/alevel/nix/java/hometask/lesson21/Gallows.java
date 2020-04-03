package com.alevel.nix.java.hometask.lesson21;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

public class Gallows {
    private StringBuilder searchString;
    private StringBuilder actualString;
    private int countClosedLetters;

    private Gallows(StringBuilder searchString, StringBuilder actualString) {
        this.searchString = searchString;
        this.actualString = actualString;
        this.countClosedLetters = actualString.length();
    }

    private static Optional<String> getRandomLine(){
        try(var resource = ClassLoader.getSystemResourceAsStream("Words.txt")){

            byte[] bytes = Objects.requireNonNull(resource).readAllBytes();

            String[] strings = new String(bytes).split(System.lineSeparator());

            return Optional.ofNullable(strings[(int) (Math.random() * strings.length)]);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    private static Optional<StringBuilder> getStartStr(int length){
        StringBuilder str = new StringBuilder();

        str.append("*".repeat(length));

        return Optional.of(str);
    }

    public String getActualString() {
        return actualString.toString();
    }

    public int getCountClosedLetters() {
        return countClosedLetters;
    }

    public static Gallows build(){
        StringBuilder searchString = new StringBuilder(getRandomLine().get());
        StringBuilder actualString = Objects.requireNonNull(getStartStr(searchString.length()).get());

        return new Gallows(searchString, actualString);
    }

    public boolean containChar(char searchChar){
        boolean flag = false;
        int index = -1;

        while((index = searchString.indexOf(String.valueOf(searchChar),index+1)) >= 0){
            actualString.replace(index,index+1,String.valueOf(searchChar));
            countClosedLetters--;
            flag = true;
        }

        return flag;
    }

}
