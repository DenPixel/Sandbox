package hiber.graf.entity;


import javax.persistence.*;

@Entity
@Table(name = "routes")
public class Route {

    @Id
    @OneToOne(mappedBy="route")
    @JoinColumn(name = "problem_id")
    private Problem problemId;

    @Column(name = "min_cost")
    private Long minCost;

    public Route() {
    }

    public Problem getProblemId() {
        return problemId;
    }

    public void setProblemId(Problem problemId) {
        this.problemId = problemId;
    }

    public Long getMinCost() {
        return minCost;
    }

    public void setMinCost(Long minCost) {
        this.minCost = minCost;
    }

    public void addProblem(Problem problem){
        problemId=problem;
        problem.setRoute(this);
    }
}
