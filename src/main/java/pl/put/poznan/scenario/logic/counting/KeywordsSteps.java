package pl.put.poznan.scenario.logic.counting;

import pl.put.poznan.scenario.model.Step;
import java.util.List;

public class KeywordsSteps extends CountingVisitor
{
    public int count(List<Step> steps)
    {
        return steps.stream()
                .filter(KeywordsSteps::isKeyword)
                .map(step -> count(step.getSubsteps())+1)
                .mapToInt(Integer::intValue)
                .sum();
    }

    private static boolean isKeyword(Step step)
    {
        List<String> content = step.getContent();
        return content.get(0).equals("IF") || content.get(0).equals("FOR EACH") || content.get(0).equals("ELSE");
    }
}
