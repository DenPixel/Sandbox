package org.pixel.model;

public class Route {

    private Problem problem;

    private int edgeWeight = Integer.MAX_VALUE;

    public Route() {
    }

    public Route(Problem problem, int edgeWeight) {
        this.problem = problem;
        this.edgeWeight = edgeWeight;
    }

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    public int getEdgeWeight() {
        return edgeWeight;
    }

    public void setEdgeWeight(int edgeWeight) {
        this.edgeWeight = edgeWeight;
    }
}
