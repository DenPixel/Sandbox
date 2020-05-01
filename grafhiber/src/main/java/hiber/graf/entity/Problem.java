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

    @ManyToOne
    @JoinColumn(name = "from_id")
    private City cityFrom;

    @ManyToOne
    @JoinColumn(name = "to_id")
    private City cityTo;

    @OneToOne(mappedBy = "problem")
    private Route route;

    public Problem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public City getCityFrom() {
        return cityFrom;
    }

    public void setCityFrom(City cityFrom) {
        this.cityFrom = cityFrom;
    }

    public City getCityTo() {
        return cityTo;
    }

    public void setCityTo(City cityTo) {
        this.cityTo = cityTo;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public void addProblem(City cityFrom, City cityTo){
        this.cityFrom = cityFrom;
        this.cityTo = cityTo;
        cityFrom.getProblems().add(this);
        cityTo.getProblemsOf().add(this);
    }
}
