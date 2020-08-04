package com.pixel.sandbox.CsvTable;

import java.io.IOException;

public class CsvTableRunner {
    public static void main(String[] args) {
        if (args.length < 1) return;

        CsvTable table;

        try {
            table = new CsvTable(args[0]);

            System.out.println(table.getElement(2, 2));

            System.out.println(table.getElement(0, "вок2"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
