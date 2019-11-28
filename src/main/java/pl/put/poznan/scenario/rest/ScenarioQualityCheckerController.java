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


@RestController
public class ScenarioQualityCheckerController
{
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
        return scenario.acceptCounting(visitor);
    }

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
        return scenario.acceptCounting(visitor);
    }
}
