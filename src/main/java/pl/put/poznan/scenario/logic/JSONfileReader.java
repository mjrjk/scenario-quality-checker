package pl.put.poznan.scenario.logic;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONfileReader {

    private File getFileFromResources(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();

        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return new File(resource.getFile());
        }

    }

    public String toString(String filename) {

        String filepath = getFileFromResources(filename + ".json").getPath();
        String content = "";
        try {
            content = new String ( Files.readAllBytes( Paths.get(filepath) ) );
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return content;

    }
}
