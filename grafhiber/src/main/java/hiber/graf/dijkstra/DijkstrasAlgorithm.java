package hiber.graf.dijkstra;

import hiber.graf.entity.City;
import hiber.graf.entity.Connection;
import hiber.graf.entity.Problem;
import hiber.graf.entity.Route;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.*;


public class DijkstrasAlgorithm {


    private Set<Problem> loadUnresolvedProblems(SessionFactory sessionFactory){
        Set<Problem> problems;

        try(Session session = sessionFactory.openSession()) {

            problems = new HashSet<>(
                    session.createQuery(
                            "SELECT p " +
                                    "FROM Problem p LEFT JOIN Route r " +
                                    "on p.id = r.problemId " +
                                    "WHERE  r.problemId IS NULL ",
                            Problem.class
                    ).getResultList()
            );
        } catch (Exception e){
            throw new RuntimeException(e);
        }

        return problems;
    }

    private HashMap<Integer, City> loadCities(SessionFactory sessionFactory){
        Set<City> cities;

        try(Session session = sessionFactory.openSession()) {

            cities = new HashSet<>(
                    session.createQuery(
                            "from City ci",
                            City.class
                    ).getResultList()
            );

          ;

        } catch (Exception e){
            throw new RuntimeException(e);
        }

        HashMap<Integer, City> graf = new HashMap<>();

        for (City city : cities) {
            city.setAdjacentCities(loadConnectionsByCity(sessionFactory,city));
            graf.put(city.getId().intValue(),city);
        }


        return graf;
    }

    private List<Connection> loadConnectionsByCity(SessionFactory sessionFactory, City city){
        List<Connection> connections;

        try (Session session = sessionFactory.openSession()) {

            connections = session.createQuery(
                    "SELECT con " +
                            "FROM Connection con " +
                            "WHERE con.cityFrom.id = :id ",
                    Connection.class
            ).setParameter("id", city.getId())
                    .getResultList();

        }catch (Exception e){
            throw new RuntimeException();
        }
        return connections;
    }

    public void solutionProblems(SessionFactory sessionFactory){
        Objects.requireNonNull(sessionFactory);

        Set<Problem> problems = loadUnresolvedProblems(sessionFactory);

        if(problems == null || problems.size() == 0) return;

        HashMap<Integer, City> cities = loadCities(sessionFactory);

        for (Problem problem : problems) {
            City cityStart= cities.get(problem.getCityFrom().getId().intValue());
            City cityEnd = cities.get(problem.getCityTo().getId().intValue());

            cityStart.setWeight(0);

            walkWay(cities, cityStart, cityEnd);

            System.out.println(cityEnd.getWeight());

            output(sessionFactory, problem, cityEnd.getWeight());

            for (Map.Entry<Integer, City> entry : cities.entrySet()) {
                entry.getValue().setWeightDefault();
            }

        }

    }

    private void walkWay(HashMap<Integer, City> cities, City city, City endCity){
        if(city.equals(endCity)) return;

        Set<Map.Entry<Integer, Integer>> nextCities = city.getAdjacentCities().entrySet();

        for (Map.Entry<Integer, Integer> nextCity : nextCities) {

            City cityTo = cities.get(nextCity.getKey());
            int cost = nextCity.getValue();

            if ((city.getWeight() + cost) < cityTo.getWeight()){
                cityTo.setWeight(city.getWeight() + cost);
                walkWay(cities,cityTo,endCity);
            }
        }
        return;
    }

    private void output (SessionFactory sessionFactory, Problem Problem, Integer minCost){

        Route route = new Route();

        route.setProblem(Problem);

        if (minCost == Integer.MAX_VALUE) {
            route.setMinCost(null);
        } else {
            route.setMinCost(minCost.longValue());
        }
        try(Session session = sessionFactory.openSession()) {

            try {
                session.beginTransaction();

                session.save(route);

                session.getTransaction().commit();
            } catch (Exception e){
                session.getTransaction().rollback();
                throw new RuntimeException(e);
            }

        }
    }
}
