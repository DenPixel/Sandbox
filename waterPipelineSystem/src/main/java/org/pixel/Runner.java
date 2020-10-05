package org.pixel;

import org.pixel.model.Graph;
import org.pixel.model.Problem;
import org.pixel.model.Route;
import org.pixel.io.LoadDataGraph;
import org.pixel.io.LoadDataProblem;
import org.pixel.io.OutputData;
import org.pixel.solution.SolutionProblem;

import java.io.IOException;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        try {
            LoadDataGraph loadDataGraph = new LoadDataGraph();
            Graph graph = loadDataGraph.loadFromCSV(args[0]);

            LoadDataProblem loadDataProblem = new LoadDataProblem();
            List<Problem> problems = loadDataProblem.loadProblemsFromCSV(args[1], graph);

            SolutionProblem solutionProblem = new SolutionProblem();

            List<Route> routes = solutionProblem.solution(graph, problems);

            OutputData outputData = new OutputData();
            outputData.outputToCSV(args[2], routes);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
