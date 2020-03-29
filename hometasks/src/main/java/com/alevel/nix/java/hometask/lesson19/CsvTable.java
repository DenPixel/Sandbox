package com.alevel.nix.java.hometask.lesson19.practice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CsvTable {

    private final String CSV_DELIMITER = ",";

    private String[] headers;

    private List<String[]> table;

    private boolean isCsv(String path){
        if(!path.toLowerCase().endsWith(".csv")){
            return false;
        }
        return true;
    }

    private void isLegalRow(int row){
        if (row < 0 || row >= table.size()){
            throw new IllegalArgumentException();
        }
    }

    private void isLegalCol(int col){
        if (col < 0 || col >= headers.length){
            throw new IllegalArgumentException();
        }
    }

    private String[] getLine(int row){
        return table.get(row);
    }

    private boolean setTable(String path){

        if (!isCsv(path)){
            return false;
        }

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {

            headers = br.lines()
                    .findFirst()
                    .get()
                    .split(CSV_DELIMITER);


            table = br.lines()
                    .map(s -> s.split(CSV_DELIMITER))
                    .filter(s -> s.length == headers.length)
                    .collect(Collectors.toList());

            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;

    }

    public CsvTable(String path) throws IOException {

        if (!setTable(path)) throw new IOException();

    }

    public String getElement(int row, int col){
        isLegalRow(row);
        isLegalCol(col);

        String[] line = getLine(row);

        return line[col];

    }

    public String getElement(int row, String headText){
        isLegalRow(row);

        int indexCol = 0;

        while (!headers[indexCol++].contains(headText)){
            if (indexCol >= headers.length){
                throw new IllegalArgumentException();
            }
        }

        String[] line = getLine(row);

        return line[indexCol];

    }


    public static void main(String[] args) {
        CsvTable table;

        try {
            table = new CsvTable("hometasks/src/main/java/com/alevel/nix/java/hometask/lesson19/practice/something.csv");

            System.out.println(table.getElement(2, 2));

            System.out.println(table.getElement(0, "вок2"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
