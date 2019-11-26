package pl.put.poznan.scenario.logic;

import pl.put.poznan.scenario.model.Step;
import java.util.List;

public class ScenarioQualityChecker {

    public static int countAllSteps(List<Step> steps) {
        int count = steps.stream()
                    .map(step -> countAllSteps(step.getSubsteps()))
                    .mapToInt(Integer::intValue)
                    .sum();
        return steps.size() + count;
    }

    public static int countKeywordsSteps(List<Step> steps) {
        return steps.stream()
                .filter(ScenarioQualityChecker::isKeyword)
                .map(step -> countKeywordsSteps(step.getSubsteps())+1)
                .mapToInt(Integer::intValue)
                .sum();
    }

    private static boolean isKeyword(Step step) {
        List<String> content = step.getContent();
        return content.get(0).equals("IF") || content.get(0).equals("FOR EACH") || content.get(0).equals("ELSE");
    }

}
