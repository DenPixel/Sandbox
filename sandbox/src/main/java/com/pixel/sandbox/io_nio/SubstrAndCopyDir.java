package com.pixel.sandbox.io_nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Collectors;


public class SubstrAndCopyDir {


    public List<String> stringsWithSubstring(String path, String subString){

        try {
            return Files.lines(Paths.get(path))
                    .filter(s -> s.contains(subString))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean copyDir(Path pathFrom, Path pathTo){


        try {
            Files.list(pathFrom)
                    .filter(path -> Files.isRegularFile(path))
                    .forEach(path -> {
                        try {
                            Path filePath = Paths.get(pathTo.toString(),path.getFileName().toString());
                            Files.copy(path,filePath, StandardCopyOption.REPLACE_EXISTING);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });

            Files.list(pathFrom)
                    .filter(path -> Files.isDirectory(path))
                    .forEach(path -> {
                        try {
                            Path dirPath = Paths.get(pathTo.toString(), path.getFileName().toString());
                            Files.createDirectory(dirPath);
                            copyDir(path, dirPath);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });

            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean copyDir(String pathFrom, String pathTo){
        return copyDir(Paths.get(pathFrom),Paths.get(pathTo));
    }
}
