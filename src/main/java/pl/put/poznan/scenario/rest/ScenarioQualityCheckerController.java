package pl.put.poznan.scenario.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.put.poznan.scenario.logic.JSONfileReader;
import pl.put.poznan.scenario.logic.JSONtoObject;
import pl.put.poznan.scenario.logic.ScenarioQualityChecker;
import pl.put.poznan.scenario.model.Scenario;


@RestController
public class ScenarioQualityCheckerController {

    @RequestMapping(method = RequestMethod.GET, path = "/all-steps-count/{filename}")
    public int countAllSteps(@PathVariable String filename) {
        String JSONfile = new JSONfileReader().toString(filename);

        if(JSONfile == "{}" || JSONfile == "")
            return 0;

        Scenario scenario = JSONtoObject.getObject(JSONfile);
        return ScenarioQualityChecker.countAllSteps(scenario.getSteps());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/keywords-count/{filename}")
    public int countKeyWordsSteps(@PathVariable String filename) {
        String JSONfile = new JSONfileReader().toString(filename);

        if(JSONfile == "{}" || JSONfile == "")
            return 0;

        Scenario scenario = JSONtoObject.getObject(JSONfile);
        return ScenarioQualityChecker.countKeywordsSteps(scenario.getSteps());
    }

}
