package org.pixel.io;

import org.pixel.model.Graph;
import org.pixel.model.Node;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class LoadDataGraph {

    private static final String CSV_DELIMITER = ";";

    public Graph loadFromCSV(String inputPath) throws IOException {
        List<String[]> content = loadContent(inputPath);
        Map<Integer, Node> graph = new HashMap<>();
        Map<Node, Map<Node, Integer>> network = new HashMap<>();

        for (String[] strings : content) {
            int idX = Integer.parseInt(strings[0]);
            Node nodeX = graph.containsKey(idX) ? graph.get(idX) : new Node(idX);
            int idY = Integer.parseInt(strings[1]);
            Node nodeY = graph.containsKey(idY) ? graph.get(idY) : new Node(idY);
            int length = Integer.parseInt(strings[2]);

            graph.put(idX, nodeX);
            graph.put(idY, nodeY);

            Map<Node, Integer> adjacentNodes = network.getOrDefault(nodeX, new HashMap<>());

            adjacentNodes.put(nodeY, length);

            network.put(nodeX,adjacentNodes);
        }

        for (Map.Entry<Node, Map<Node, Integer>> entry : network.entrySet()) {
            Node node = entry.getKey();
            Map<Node, Integer> adjacent = entry.getValue();

            node.setAdjacentNodes(adjacent);
        }

        return new Graph(graph.values());
    }

    private List<String[]> loadContent(String inputPath) throws IOException {
        String content = Files.readString(Path.of(inputPath));

        return content.lines()
                .skip(1)
                .map(s -> s.split(CSV_DELIMITER))
                .collect(Collectors.toList());
    }
}
