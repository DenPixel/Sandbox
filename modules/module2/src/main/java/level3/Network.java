package level3;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Network {
    private final static int MAX_COST = 200_000;
    private final static int MAX_COUNT_CITY = 10_000;
    private final static int MAX_COUNT_WAY = 100;
    private final static String INPUT_PATH = ClassLoader.getSystemResource("input.txt").getPath();
    private int[] minCosts;
    private List<City> network = new ArrayList<>();
    private List<String[]> ways = new ArrayList<>();

    public Network() {
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

            minCosts = new int[countWay];
            Arrays.fill(minCosts, -1);

        }catch (IOException e){
            e.printStackTrace();
        }
    }



    void counting(){
        int indexCost = 0;
        for (String[] way : ways) {
            int startWay = getIndexCity(way[0]);
            int endWay = getIndexCity(way[1]);

            for (int i : network.get(startWay-1).getIndexNextCities()){
                int sum = costWay(
                        getCostWay(startWay,i),
                        indexCost,
                        startWay,
                        endWay,
                        i,
                        startWay
                );
                if (minCosts[indexCost] < 0){
                    minCosts[indexCost] = sum;
                }else {
                    minCosts[indexCost] = Math.min(minCosts[indexCost],sum);
                }

            }
            indexCost++;
        }

        System.out.println(Arrays.toString(minCosts));


    }

    private int costWay(int sum, int indexCost, int indexStart, int indexEnd, int indexTemp, int indexPrev){

        for (int i : network.get(indexTemp-1).getIndexNextCities()) {

            if (i != indexStart && i != indexPrev && indexEnd != indexTemp){
                sum = costWay(
                        sum+getCostWay(indexTemp,i),
                        indexCost,
                        indexStart,
                        indexEnd,
                        i,
                        indexTemp
                );
            }
            if (indexEnd == indexTemp){
                if (minCosts[indexCost] < 0){
                    minCosts[indexCost] = sum;
                }else {
                    minCosts[indexCost] = Math.min(minCosts[indexCost], sum);
                }
                return minCosts[indexCost];
            }

        }

        return minCosts[indexCost];
    }


    private int getCostWay(int indexStartCity, int indexNextCity){
        return network.get(indexStartCity-1).getCostWay(indexNextCity);
    }

    private int getIndexCity(String nameCity){
         return network.stream()
                .filter(city -> city.getName().equals(nameCity))
                .findFirst()
                .get()
                .getIndex();
    }


    public static void main(String[] args) {
        Network n = new Network();
        n.counting();
    }
}
