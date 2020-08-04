package com.pixel.jdbcbox;

import java.io.*;
import java.sql.*;
import java.util.*;

public class Network {
    private final static int MAX_COST = 200_000;
    private Map<Integer,City> network;

    private static Properties loadProperties() {

        Properties props = new Properties();

        try(InputStream input = ClassLoader.getSystemResourceAsStream("JdbcBox.properties")) {
            props.load(input);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        return props;
    }

    public static Network build(){
        Map<Integer,City> network = new HashMap<>();

        Properties properties = loadProperties();
        String url = properties.getProperty("url");

        try(Connection connection = DriverManager.getConnection(url, properties)) {
            try(PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM city")) {
                ResultSet cities = statement.executeQuery();


                while (cities.next()) {
                    SortedMap<Integer, Integer> neighboring = new TreeMap<>();

                    try(PreparedStatement preparedStatement = connection.prepareStatement(
                            "SELECT con.cost, con.to FROM connections con WHERE con.from=?")) {

                        preparedStatement.setInt(1,cities.getInt("id"));

                        ResultSet connect = preparedStatement.executeQuery();

                        while (connect.next()) {
                            neighboring.put(
                                    connect.getInt("to"),
                                    Integer.min(connect.getInt("cost"), MAX_COST)
                            );
                        }
                    }

                    City city = new City(
                            cities.getString("name"),
                            cities.getInt("id"),
                            neighboring
                    );

                    network.put(cities.getInt("id"),city);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new Network(network);
    }

    private Network(Map<Integer,City> network){
        this.network = network;
    }

    public void searchMinWayCosts(){
        Properties properties = loadProperties();
        String url = properties.getProperty("url");

        Map<Integer, Integer> problemAndResult = new HashMap<>();

        try(Connection connection = DriverManager.getConnection(url,properties)) {
            try(PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM problems")) {
                ResultSet problems = preparedStatement.executeQuery();

                while (problems.next()) {
                    int startWay = problems.getInt("from");
                    int endWay = problems.getInt("to");

                    City city = network.get(startWay);

                    City endCity = network.get(endWay);

                    city.setWeight(0);

                    walkWay(city,endCity);

                    problemAndResult.put(problems.getInt("id"), endCity.getWeight());

                    Iterator<Map.Entry<Integer, City>> iterator = network.entrySet().iterator();

                    while (iterator.hasNext()) {
                        iterator.next().getValue().setWeight(Integer.MAX_VALUE);
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        output(problemAndResult);
    }

    private void walkWay(City city, City endCity){
        if(city.getIndex() == endCity.getIndex()){
            return;
        }

        Set<Integer> indexNextCities = city.getIndexNextCities();
        City nextCity;

        for (int indexNextCity : indexNextCities) {
            nextCity = network.get(indexNextCity);
            if ((city.getCostWay(indexNextCity) + city.getWeight()) < nextCity.getWeight()){
                nextCity.setWeight(city.getCostWay(indexNextCity) + city.getWeight());
                walkWay(nextCity, endCity);
            }
        }
    }

    private void output(Map<Integer, Integer> problemAndResult){
        Properties properties = loadProperties();
        String url = properties.getProperty("url");

        try(Connection connection = DriverManager.getConnection(url, properties)){
            Iterator<Map.Entry<Integer, Integer>> iterator = problemAndResult.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> next = iterator.next();

                if (next.getValue() >= Integer.MAX_VALUE){
                    try(PreparedStatement insertImpRout = connection.prepareStatement(
                            "INSERT INTO impossible_routes (problem_id) values (?)" +
                                    "ON CONFLICT DO NOTHING ")) {
                        insertImpRout.setInt(1, next.getKey());

                        insertImpRout.addBatch();
                        insertImpRout.executeBatch();
                    }

                    try(PreparedStatement delFoundRout = connection.prepareStatement(
                            "DELETE FROM found_routes fr WHERE fr.id = ?")){
                        delFoundRout.setInt(1, next.getKey());

                        delFoundRout.addBatch();
                        delFoundRout.executeBatch();
                    }
                }else {
                    try(PreparedStatement insertFoundRout = connection.prepareStatement(
                            "INSERT INTO found_routes (id,min_cost) values (?,?) " +
                                    "ON CONFLICT (id) " +
                                    "DO UPDATE SET min_cost = ?")) {
                        insertFoundRout.setInt(1, next.getKey());
                        insertFoundRout.setInt(2,next.getValue());
                        insertFoundRout.setInt(3,next.getValue());

                        insertFoundRout.addBatch();
                        insertFoundRout.executeBatch();
                    }

                    try(PreparedStatement delFoundRout = connection.prepareStatement(
                            "DELETE FROM impossible_routes im WHERE im.problem_id = ?")){
                        delFoundRout.setInt(1, next.getKey());

                        delFoundRout.addBatch();
                        delFoundRout.executeBatch();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
