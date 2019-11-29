package pl.put.poznan.scenario.logic.counting;

import pl.put.poznan.scenario.model.Step;

/**
 * AllSteps class counts all steps (including substeps) in scenario.
 * It extends abstract class CountingVisitor and uses Visitor design pattern.
 *
 * @author Anna Lubawa
 */
public class AllSteps extends CountingVisitor
{
    private int stepsNumber = 0;

    public int getStepsNumber() {
        return stepsNumber;
    }

    public void count(Step step)
    {
        stepsNumber++;
    }

    public void afterCounting()
    {
        stepsNumber = 0;
    }
}
