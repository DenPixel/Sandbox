package com.pixel.sandbox.io_nio.gallows;

import java.io.IOException;
import java.util.Objects;

public class Gallows {
    private StringBuilder searchString;
    private StringBuilder actualString;
    private int countClosedLetters;

    private Gallows(StringBuilder searchString, StringBuilder actualString) {
        this.searchString = searchString;
        this.actualString = actualString;
        this.countClosedLetters = actualString.length();
    }

    private static String getRandomLine(){
        try(var resource = ClassLoader.getSystemResourceAsStream("Words.txt")){
            byte[] bytes = Objects.requireNonNull(resource).readAllBytes();

            String[] strings = new String(bytes).split(System.lineSeparator());

            return strings[(int) (Math.random() * strings.length)];
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    private static StringBuilder getStartStr(int length){
        StringBuilder str = new StringBuilder();

        str.append("*".repeat(length));

        return str;
    }

    public String getActualString() {
        return actualString.toString();
    }

    public int getCountClosedLetters() {
        return countClosedLetters;
    }

    public static Gallows build(){
        StringBuilder searchString = new StringBuilder(getRandomLine());
        StringBuilder actualString = getStartStr(searchString.length());

        return new Gallows(searchString, actualString);
    }

    public boolean containChar(char searchChar){
        boolean flag = false;
        int index = -1;

        while((index = searchString.indexOf(String.valueOf(searchChar),index+1)) >= 0){

            if (actualString.charAt(index) == '*'){
                actualString.setCharAt(index,searchChar);
                countClosedLetters--;
            }

            flag = true;
        }

        return flag;
    }

}
