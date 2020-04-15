package com.alevel.jdbcbox.lesson24.level3;

import java.util.Set;
import java.util.SortedMap;

public class City {
    private String name;
    private int index;
    private SortedMap<Integer, Integer> neighboring;
    private int weight = Integer.MAX_VALUE;

    public City(String name, int index, SortedMap<Integer, Integer> neighboring) {
        this.name = name;
        this.index = index;
        this.neighboring = neighboring;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }

    public SortedMap<Integer, Integer> getNeighboring() {
        return neighboring;
    }

    public int getCostWay(int indexNextCity){
        return neighboring.get(indexNextCity);
    }

    public Set<Integer> getIndexNextCities(){
        return neighboring.keySet();
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
