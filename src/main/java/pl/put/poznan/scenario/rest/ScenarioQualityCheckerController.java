package pl.put.poznan.scenario.rest;

import com.google.gson.JsonSyntaxException;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.scenario.logic.JSONfileReader;
import pl.put.poznan.scenario.logic.JSONfileWriter;
import pl.put.poznan.scenario.logic.JSONtoObject;
import pl.put.poznan.scenario.logic.counting.AllSteps;
import pl.put.poznan.scenario.logic.counting.CountingVisitor;
import pl.put.poznan.scenario.logic.counting.KeywordsSteps;
import pl.put.poznan.scenario.logic.counting.NoActorSteps;
import pl.put.poznan.scenario.logic.displaying.DisplayingVisitor;
import pl.put.poznan.scenario.logic.displaying.ScenarioLevelViewer;
import pl.put.poznan.scenario.logic.displaying.ScenarioViewer;
import pl.put.poznan.scenario.model.Scenario;

/**
 * This class is a REST Controller, which is responsible for processing incoming requests.
 * It invokes scenario processing functions.
 *
 * @author Anna Lubawa
 */
@RestController
public class ScenarioQualityCheckerController
{
    /**
     * Counts number of all steps (including substeps) in a scenario.
     *
     * @param filename      name of JSON file with a scenario
     * @return              number of all steps in scenario
     */
    @RequestMapping(method = RequestMethod.GET, path = "/all-steps/{filename}")
    public int countAllSteps(@PathVariable String filename)
    {
        String JSONfile = new JSONfileReader().toString(filename);

        if(JSONfile == "{}" || JSONfile == "")
            return 0;

        Scenario scenario;
        try {
            scenario = JSONtoObject.getObject(JSONfile);
        }
        catch (JsonSyntaxException e) {
            return 0;
        }

        CountingVisitor visitor = new AllSteps();
        scenario.acceptCounting(visitor);
        int result = ((AllSteps) visitor).getStepsNumber();
        visitor.afterCounting();
        return result;
    }

    /**
     * Counts number of steps containing keywords such as 'FOR', 'FOR EACH' and 'ELSE' in a scenario.
     *
     * @param filename      name of JSON file with a scenario
     * @return              number of steps containing keywords
     */
    @RequestMapping(method = RequestMethod.GET, path = "/keywords-steps/{filename}")
    public int countKeyWordsSteps(@PathVariable String filename)
    {
        String JSONfile = new JSONfileReader().toString(filename);

        if(JSONfile == "{}" || JSONfile == "")
            return 0;

        Scenario scenario;
        try {
            scenario = JSONtoObject.getObject(JSONfile);
        }
        catch (JsonSyntaxException e) {
            return 0;
        }

        CountingVisitor visitor = new KeywordsSteps();
        scenario.acceptCounting(visitor);
        int result = ((KeywordsSteps) visitor).getStepsNumber();
        visitor.afterCounting();
        return  result;
    }

    /**
     * Counts number of steps in a scenario with no actor assigned.
     *
     * @param filename      name of JSON file with a scenario
     * @return              number of steps containing keywords
     */
    @RequestMapping(method = RequestMethod.GET, path = "/no-actor-steps/{filename}")
    public int countNoActorSteps(@PathVariable String filename)
    {
        String JSONfile = new JSONfileReader().toString(filename);

        if(JSONfile == "{}" || JSONfile == "")
            return 0;

        Scenario scenario;
        try {
            scenario = JSONtoObject.getObject(JSONfile);
        }
        catch (JsonSyntaxException e) {
            return 0;
        }

        CountingVisitor visitor = new NoActorSteps();
        scenario.acceptCounting(visitor);
        int result = ((NoActorSteps) visitor).getStepsNumber();
        visitor.afterCounting();
        return  result;
    }

    /**
     * Displays all steps in a scenario.
     *
     * @param filename      name of JSON file with a scenario
     * @return              String with scenario with numbered steps.
     */
    @RequestMapping(method = RequestMethod.GET, path = "/show-scenario/{filename}")
    public String showScenario(@PathVariable String filename)
    {
        String JSONfile = new JSONfileReader().toString(filename);

        Scenario scenario;
        try {
            scenario = JSONtoObject.getObject(JSONfile);
        }
        catch (JsonSyntaxException e) {
            return "Błędna struktura scenariusza.";
        }

        DisplayingVisitor visitor = new ScenarioViewer();
        scenario.acceptDisplaying(visitor);
        return ((ScenarioViewer) visitor).getScenarioText();
    }

    /**
     * Displays steps in a scenario but only to certain level of substeps.
     *
     * @param filename      name of JSON file with a scenario
     * @param level         level of displayed substeps
     * @return              String with scenario with numbered steps.
     */
    @RequestMapping(method = RequestMethod.GET, path = "/show-scenario/{level}/{filename}")
    public String showLevelScenario(@PathVariable String filename, @PathVariable int level)
    {
        String JSONfile = new JSONfileReader().toString(filename);

        Scenario scenario;
        try {
            scenario = JSONtoObject.getObject(JSONfile);
        }
        catch (JsonSyntaxException e) {
            return "Błędna struktura scenariusza.";
        }

        DisplayingVisitor visitor = new ScenarioLevelViewer(level);
        scenario.acceptDisplaying(visitor);
        return ((ScenarioLevelViewer) visitor).getScenarioText();
    }

    /**
     * Creates new scenario from POST request
     *
     * @param title     name for new JSON file with a scenario
     */
    @RequestMapping(method = RequestMethod.POST, path = "/add-scenario/{title}")
    public String addScenario(@PathVariable String title, @RequestBody Scenario scenario)
    {
        return JSONfileWriter.writeScenarioToFile(scenario, title);
    }
}

