package org.pixel.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Graph {

    private Set<Node> nodes = new HashSet<>();

    public Graph(Collection<Node> values) {
        this.nodes.addAll(values);
    }

    public Graph(Set<Node> nodes) {
        this.nodes = nodes;
    }

    public void addNode(Node nodeA) {
        nodes.add(nodeA);
    }

    public Set<Node> getNodes() {

        return nodes;
    }

    public void setNodes(Set<Node> nodes) {
        this.nodes = nodes;
    }


}
