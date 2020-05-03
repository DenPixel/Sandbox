package hiber.graf.entity;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.*;


@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NaturalId
    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "cityFrom")
    private final Set<Connection> connections = new HashSet<>();

    @OneToMany(mappedBy = "cityTo")
    private final Set<Connection> connectionsOf = new HashSet<>();

    @OneToMany(mappedBy = "cityFrom")
    private final List<Problem> problems = new ArrayList<>();

    @OneToMany(mappedBy = "cityTo")
    private final List<Problem> problemsOf = new ArrayList<>();

    @Transient
    private int weight = Integer.MAX_VALUE;

    @Transient
    private Map<Integer, Integer> adjacentCities;

    public City() {
    }

    public City(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Connection> getConnections() {
        return connections;
    }

    public Set<Connection> getConnectionsOf() {
        return connectionsOf;
    }

    public List<Problem> getProblems() {
        return problems;
    }

    public List<Problem> getProblemsOf() {
        return problemsOf;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setWeightDefault(){
        this.weight = Integer.MAX_VALUE;
    }

    public void setAdjacentCities(Collection<Connection> connections){
        Map<Integer, Integer> adjacentCities = new HashMap<>();

        for (Connection connection : connections) {
            adjacentCities.put(connection.getCityTo().id.intValue(),
                    connection.getCost());
        }

        this.adjacentCities = adjacentCities;
    }

    public Map<Integer, Integer> getAdjacentCities() {
        return adjacentCities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(id, city.id) &&
                Objects.equals(name, city.name);
    }
}
