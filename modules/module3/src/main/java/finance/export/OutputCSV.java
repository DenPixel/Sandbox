package finance.export;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OutputCSV {

    private final static Logger log = LoggerFactory.getLogger(OutputCSV.class);

    public void outputToCSV(String pathDir, String name, String forOutput ){

        log.info("start output data into csv");

        try {
            File file = new File(pathDir, name + ".csv");
            file.createNewFile();

            try(FileWriter writer = new FileWriter(file)) {
                writer.write(forOutput);
                writer.flush();
            }

        } catch (IOException e) {
            log.info("fail output data into csv");
            throw new RuntimeException(e);
        }

        log.info("finish output data into csv");
    }
}
