package org.pixel.io;

import org.pixel.model.Route;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class OutputData {
    
    public void outputToCSV(String outputPath, List<Route> routes) throws IOException {
        StringBuilder output = new StringBuilder("ROUTE EXISTS;MIN LENGTH\n");
        for (Route route : routes) {
            int edgeWeight = route.getEdgeWeight();
            boolean routeExist = edgeWeight != Integer.MAX_VALUE;

            output.append(routeExist);
            output.append(";");
            if (routeExist) output.append(edgeWeight);
            output.append(System.lineSeparator());
        }

        Files.writeString(Path.of(outputPath), output);
    }
    
}
