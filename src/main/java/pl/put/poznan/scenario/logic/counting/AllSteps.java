package pl.put.poznan.scenario.logic.counting;

import pl.put.poznan.scenario.model.Step;
import java.util.List;

public class AllSteps extends CountingVisitor
{
    public int count(List<Step> steps)
    {
        int count = steps.stream()
                .map(step -> count(step.getSubsteps()))
                .mapToInt(Integer::intValue)
                .sum();
        return steps.size() + count;
    }
}
