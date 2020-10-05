package org.pixel.io;

import org.pixel.model.Graph;
import org.pixel.model.Node;
import org.pixel.model.Problem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LoadDataProblem {

    public List<Problem> loadProblemsFromCSV(String inputPath, Graph graph) throws IOException {
        List<String[]> content = loadContent(inputPath);
        List<Problem> problems = new ArrayList<>();
        Set<Node> nodes = graph.getNodes();

        for (String[] strings : content) {
            Problem problem = new Problem();
            int idFrom = Integer.parseInt(strings[0]);
            int idTo = Integer.parseInt(strings[1]);

            Node nodeFrom = nodes.stream()
                    .filter(node -> node.getId() == idFrom)
                    .findFirst()
                    .orElseThrow();
            Node nodeTo = nodes.stream()
                    .filter(node -> node.getId() == idTo)
                    .findFirst()
                    .orElseThrow();

            problem.setNodeFrom(nodeFrom);
            problem.setNodeTo(nodeTo);

            problems.add(problem);
        }

        return problems;
    }

    private List<String[]> loadContent(String inputPath) throws IOException {
        String content = Files.readString(Path.of(inputPath));

        return content.lines()
                .skip(1)
                .map(s -> s.split(";"))
                .collect(Collectors.toList());
    }
}
