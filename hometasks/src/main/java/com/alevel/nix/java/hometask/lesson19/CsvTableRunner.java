package com.alevel.nix.java.hometask.lesson19;

import java.io.IOException;

public class CsvTableRunner {
    public static void main(String[] args) {
        CsvTable table;

        try {
            table = new CsvTable("hometasks/src/main/java/com/alevel/nix/java/hometask/lesson19/something.csv");

            System.out.println(table.getElement(2, 2));

            System.out.println(table.getElement(0, "вок2"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
