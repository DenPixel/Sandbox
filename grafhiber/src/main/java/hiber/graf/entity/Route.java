package hiber.graf.entity;


import javax.persistence.*;

@Entity
@Table(name = "routes")
public class Route {

    @Id
    @Column(name = "problem_id")
    private Long problemId;

    @OneToOne
    @JoinColumn(name = "problem_id")
    @MapsId
    private Problem problem;

    @Column(name = "min_cost")
    private Long minCost;

    public Route() {
    }

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problemId) {
        this.problem = problemId;
    }

    public Long getMinCost() {
        return minCost;
    }

    public void setMinCost(Long minCost) {
        this.minCost = minCost;
    }
}
