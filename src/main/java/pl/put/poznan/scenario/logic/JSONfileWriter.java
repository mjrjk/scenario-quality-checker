package pl.put.poznan.scenario.logic;

import com.google.gson.Gson;
import pl.put.poznan.scenario.model.Scenario;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * JSONfileWriter class processes Objects and writes them as JSON files to resources folder.
 *
 */
public class JSONfileWriter {
    /**
     * Writes scenario to file.
     *
     * @param scenario      Scenario object to write
     * @param title         title of Scenario and name of file
     * @return              message about file creating operation status
     */
    public static String writeScenarioToFile(Scenario scenario, String title)
    {
        Gson gson = new Gson();
        String jsonString = gson.toJson(scenario);
        String filename = "src/main/resources/" + title + ".json";
        File file = new File(filename);
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(jsonString);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            return "Nie udało się stworzyć pliku ze scenariuszem.";
        }
        return "Stworzono plik ze scenariuszem o nazawie " + title + ".json";
    }
}
