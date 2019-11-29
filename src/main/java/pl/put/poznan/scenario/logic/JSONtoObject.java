package pl.put.poznan.scenario.logic;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import pl.put.poznan.scenario.model.Scenario;

/**
 * JSONtoObject class parses JSON to Scenario object.
 *
 */
public class JSONtoObject
{
    /**
     * Parses JSON to Scenario object.
     *
     * @param scenarioJSON      String with scenario in JSON format
     * @return                  Scenario object parsed from string
     * @throws JsonSyntaxException  when JSON structure doesn't correspond Scenario class structure
     */
    public static Scenario getObject(String scenarioJSON) throws JsonSyntaxException
    {
        Gson gson = new Gson();
        return gson.fromJson(scenarioJSON, Scenario.class);
    }
}