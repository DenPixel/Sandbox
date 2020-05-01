package hiber.graf.entity;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NaturalId
    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "cityFrom")
    private final Set<Connection> connections = new HashSet<>();

    @OneToMany(mappedBy = "cityTo")
    private final Set<Connection> connectionsOf = new HashSet<>();

    @OneToMany(mappedBy = "cityFrom")
    private final List<Problem> problems = new ArrayList<>();

    @OneToMany(mappedBy = "cityTo")
    private final List<Problem> problemsOf = new ArrayList<>();

    public City() {
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
}
