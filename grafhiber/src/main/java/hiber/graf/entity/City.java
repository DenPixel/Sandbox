package hiber.graf.entity;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NaturalId
    @Column(nullable = false)
    private String name;


    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private final List<Connection> connections = new ArrayList<>();

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private final List<Connection> connectionsOf = new ArrayList<>();

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private final List<Problem> problems = new ArrayList<>();

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
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

    public List<Connection> getConnections() {
        return connections;
    }

    public List<Connection> getConnectionsOf() {
        return connectionsOf;
    }

    public List<Problem> getProblems() {
        return problems;
    }

    public List<Problem> getProblemsOf() {
        return problemsOf;
    }
}
