package pl.put.poznan.scenario.rest;

import com.google.gson.JsonSyntaxException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.put.poznan.scenario.logic.JSONfileReader;
import pl.put.poznan.scenario.logic.JSONtoObject;
import pl.put.poznan.scenario.logic.counting.AllSteps;
import pl.put.poznan.scenario.logic.counting.CountingVisitor;
import pl.put.poznan.scenario.logic.counting.KeywordsSteps;
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
    @RequestMapping(method = RequestMethod.GET, path = "/all-steps-count/{filename}")
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
    @RequestMapping(method = RequestMethod.GET, path = "/keywords-count/{filename}")
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
}
