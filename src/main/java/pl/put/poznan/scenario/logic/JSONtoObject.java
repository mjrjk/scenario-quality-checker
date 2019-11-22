package pl.put.poznan.scenario.logic;

import com.google.gson.Gson;
import pl.put.poznan.scenario.model.Scenario;

public class JSONtoObject {

    private static Scenario getObject()
    {
        // Storing json
        // docelowo scenariusz pobrany z pliku i zamieniony na stringa
        String scenarioJSON = "{'title': 'tytul','actors': ['ac1','ac2'],'sysactors': ['acs1','acs2'],'steps': [{ 'stepNum': 1, 'content': ['Klient parkuje na stacji'], 'substeps': [], 'returnPath': [] }, { 'stepNum': 2, 'content': ['Klient oddaje dowód rejestracyjny i kluczyki'], 'substeps': [], 'returnPath': [] }]}";
        // Creating a Gson Object
        Gson gson = new Gson();
        // Converting json to object
        // parameters: json, mapping class
        Scenario scenario = gson.fromJson(scenarioJSON, Scenario.class);
        // return object
        return scenario;
    }
}