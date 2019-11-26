package pl.put.poznan.scenario.logic;

import com.google.gson.Gson;
import pl.put.poznan.scenario.model.Scenario;

public class JSONtoObject {

    public static Scenario getObject(String scenarioJSON)
    {
        Gson gson = new Gson();
        Scenario scenario = gson.fromJson(scenarioJSON, Scenario.class);
        return scenario;
    }

}