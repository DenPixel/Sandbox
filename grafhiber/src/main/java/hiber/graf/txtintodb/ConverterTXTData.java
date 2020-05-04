package hiber.graf.txtintodb;


import hiber.graf.entity.City;
import hiber.graf.entity.Connection;
import hiber.graf.entity.Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ConverterTXTData {

    private Collection<City> cities;

    private List<Connection> connections;

    private List<Problem> problems;

    private ConverterTXTData(Collection<City> cities,
                             List<Connection> connections,
                             List<Problem> problems) {
        this.cities = cities;
        this.connections = connections;
        this.problems = problems;
    }

    private static boolean isTXT(String inputPath){
        return inputPath.toLowerCase().endsWith(".txt");
    }

    public static ConverterTXTData load(String inputPath){
        if (!isTXT(inputPath)) return null;

        Map<Integer, City> citiesMap = new HashMap<>();
        Map<Integer,Map<Integer, Integer>> connectionsMap = new HashMap<>();
        List<String[]> problemsList = new ArrayList<>();

        try(BufferedReader buffer = Files.newBufferedReader(Paths.get(inputPath))){

            int countCity = Integer.parseInt(buffer.readLine());

            for (int i = 1; i <= countCity; i++) {
                City city = new City(buffer.readLine());

                citiesMap.put(i, city);

                Map<Integer, Integer> neighboring = new HashMap<>();

                int countNeighboring = Integer.parseInt(buffer.readLine());
                for (int j = 0; j < countNeighboring; j++) {
                    String[] nrCost = buffer.readLine().split(" ");
                    Integer nr = Integer.valueOf(nrCost[0]);
                    int cost = Integer.parseInt(nrCost[1]);

                    neighboring.put(nr, cost);
                }

                connectionsMap.put(i,neighboring);
            }

            int countWay = Integer.parseInt(buffer.readLine());
            for (int i = 0; i < countWay; i++) {
                problemsList.add(buffer.readLine().split(" "));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Collection<City> cities = citiesMap.values();
        List<Connection> connections = new ArrayList<>();
        List<Problem> problems =new ArrayList<>();

        for (Map.Entry<Integer, Map<Integer, Integer>> connect :
                connectionsMap.entrySet()) {

            City cityFrom = citiesMap.get(connect.getKey());

            for (Map.Entry<Integer, Integer> neighboring :
                    connect.getValue().entrySet()) {

                City cityTo = citiesMap.get(neighboring.getKey());
                int cost = neighboring.getValue();

                connections.add(new Connection(cityFrom, cityTo, cost));
            }

        }

        for (String[] problemsStr : problemsList) {

            String problemCityFrom = problemsStr[0];
            String problemCityTo = problemsStr[1];

            City cityFrom = cities.stream()
                    .filter(city -> city.getName().equals(problemCityFrom))
                    .findFirst()
                    .get();

            City cityTo = cities.stream()
                    .filter(city -> city.getName().equals(problemCityTo))
                    .findFirst()
                    .get();

            problems.add(new Problem(cityFrom, cityTo));
        }


        return new ConverterTXTData(cities,connections,problems);

    }

    public Collection<City> getCities() {
        return cities;
    }

    public List<Connection> getConnections() {
        return connections;
    }

    public List<Problem> getProblems() {
        return problems;
    }

    //    private ConverterTxtData convertToNormalData(Map<Integer, City> citiesMap,
//                                     Map<Integer,Map<Integer, Integer>> connectionsMap,
//                                     List<String[]> problemsList){
//
//        Collection<City> cities = citiesMap.values();
//
//        List<Connection> connections = new ArrayList<>();
//
//        List<Problem> problems =new ArrayList<>();
//
//        for (Map.Entry<Integer, Map<Integer, Integer>> connect :
//                connectionsMap.entrySet()) {
//
//            City cityFrom = citiesMap.get(connect.getKey());
//
//            for (Map.Entry<Integer, Integer> neighboring :
//                    connect.getValue().entrySet()) {
//
//                City cityTo = citiesMap.get(neighboring.getKey());
//                int cost = neighboring.getValue();
//
//                connections.add(new Connection(cityFrom, cityTo, cost));
//            }
//
//        }
//
//        for (String[] problemsStr : problemsList) {
//
//            String problemCityFrom = problemsStr[0];
//            String problemCityTo = problemsStr[1];
//
//            City cityFrom = cities.stream()
//                    .filter(city -> city.getName().equals(problemCityFrom))
//                    .findFirst()
//                    .get();
//
//            City cityTo = cities.stream()
//                    .filter(city -> city.getName().equals(problemCityTo))
//                    .findFirst()
//                    .get();
//
//            problems.add(new Problem(cityFrom, cityTo));
//        }
//
//
//        return new ConverterTxtData(cities,connections,problems);
//    }
}
