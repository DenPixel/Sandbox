package hiber.graf.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "problems")
public class Problem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "from_id")
    private City from;

    @ManyToOne()
    @JoinColumn(name = "to_id")
    private City to;


    @OneToOne(cascade = CascadeType.ALL)
    private Route route;

    public Problem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public City getFrom() {
        return from;
    }

    public City getTo() {
        return to;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public void addProblem(City cityFrom, City cityTo){
        from = cityFrom;
        to = cityTo;
        from.getProblems().add(this);
        to.getProblemsOf().add(this);
    }

    public void addRoute(Route route){
        this.route=route;
        route.setProblemId(this);
    }
}
