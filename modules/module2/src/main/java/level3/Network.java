package level3;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Network {
    private final static int MAX_COST = 200_000;
    private final static int MAX_COUNT_CITY = 10_000;
    private final static int MAX_COUNT_WAY = 100;
    private final  String INPUT_PATH;
    private final  String OUTPUT_PATH;
    private final List<City> network = new ArrayList<>();
    private final List<String[]> ways = new ArrayList<>();

    public Network(String inputPath, String outputPath) {
        INPUT_PATH = inputPath;
        OUTPUT_PATH = outputPath;

        try(BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(INPUT_PATH))) {

            final int countCity = Math.min(Integer.parseInt(bufferedReader.readLine()), MAX_COUNT_CITY);

            for (int i = 1; i <= countCity; i++) {
                String name = bufferedReader.readLine();
                SortedMap<Integer, Integer> neighboring = new TreeMap<>();

                int countNeighboring = Integer.parseInt(bufferedReader.readLine());
                for (int j = 0; j < countNeighboring; j++) {
                    final String[] nrCost = bufferedReader.readLine().split(" ");
                    final Integer nr = Integer.valueOf(nrCost[0]);
                    final int cost = Math.min(Integer.parseInt(nrCost[1]), MAX_COST);

                    neighboring.put(nr, cost);
                }

                network.add(new City(name, i, neighboring));
            }

            int countWay = Math.min(Integer.parseInt(bufferedReader.readLine()), MAX_COUNT_WAY);
            for (int i = 0; i < countWay; i++) {
                ways.add(bufferedReader.readLine().split(" "));
            }


        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void searchMinWayCosts(){
        StringBuilder forOutput = new StringBuilder();
        for (String[] way : ways) {
            int startWay = getIndexCity(way[0]);
            int endWay = getIndexCity(way[1]);

            City city = network.get(startWay-1);

            City endCity = network.get(endWay-1);

            city.setWeight(0);

            walkWay(city,endCity);

            forOutput.append(endCity.getWeight());
            forOutput.append(System.lineSeparator());

            for (City tempCity : network) {
                tempCity.setWeight(1_000_000);
            }
        }

        output(forOutput.toString());
    }



    private void walkWay(City city, City endCity){
        if(city.getIndex() == endCity.getIndex()){
            return;
        }

        Set<Integer> indexNextCities = city.getIndexNextCities();
        City nextCity;

        for (int indexNextCity : indexNextCities) {
            nextCity = network.get(indexNextCity-1);
            if ((city.getCostWay(indexNextCity) + city.getWeight()) < nextCity.getWeight()){
                nextCity.setWeight(city.getCostWay(indexNextCity) + city.getWeight());
                walkWay(nextCity, endCity);
            }
        }
    }

    private int getIndexCity(String nameCity){
         return network.stream()
                .filter(city -> city.getName().equals(nameCity))
                .findFirst()
                .get()
                .getIndex();
    }

    private void output(String forOutput){
        try(FileWriter writer = new FileWriter(OUTPUT_PATH)) {
            writer.write(forOutput);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Network n = new Network("modules/module2/temp/input.txt", "modules/module2/temp/output.txt");
        n.searchMinWayCosts();
    }
}
