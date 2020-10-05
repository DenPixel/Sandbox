package org.pixel.solution;

import org.pixel.model.Graph;
import org.pixel.model.Node;
import org.pixel.model.Problem;
import org.pixel.model.Route;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SolutionProblem {

    public List<Route> solution(Graph graph, List<Problem> problems){
        List<Route> routes = new ArrayList<>();

        for (Problem problem : problems) {
            Node nodeFrom = problem.getNodeFrom();
            Node nodeTo = problem.getNodeTo();

            nodeFrom.setWeight(0);

            walkWay(graph, nodeFrom, nodeTo);

            routes.add(new Route(problem, nodeTo.getWeight()));

            graph.getNodes().forEach(node -> node.setWeight(Integer.MAX_VALUE));
        }

        return routes;
    }

    private void walkWay(Graph graph, Node node, Node endNode){
        if (node.equals(endNode)) return;

        Map<Node, Integer> adjacentNodes = node.getAdjacentNodes();

        for (Map.Entry<Node, Integer> nextNode : adjacentNodes.entrySet()) {
            Node nodeTo = nextNode.getKey();
            int length = nextNode.getValue();

            int weight = node.getWeight();
            int weightTo = nodeTo.getWeight();

            int edgeWeight = weight + length;

            if (edgeWeight < weightTo){
                nodeTo.setWeight(edgeWeight);
                walkWay(graph, nodeTo, endNode);
            }
        }
    }
}
