package pl.put.poznan.scenario.logic;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * JSONfileReader class processes JSON files with scenarios from resources folder
 * to make it accessible as a string for other classes.
 *
 */
public class JSONfileReader
{
    /**
     * Accesses a JSON file from resources folder.
     *
     * @param filename      filename of scenario
     * @return              JSON file
     */
    private File getFileFromResources(String filename)
    {
        ClassLoader classLoader = getClass().getClassLoader();

        URL resource = classLoader.getResource(filename);
        if (resource == null) {
            throw new IllegalArgumentException("File is not found!");
        } else {
            return new File(resource.getFile());
        }
    }

    /**
     * Converts JSON file to string.
     *
     * @param filename      filename of scenario
     * @return              string containing whole scenario
     */
    public String toString(String filename)
    {
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
