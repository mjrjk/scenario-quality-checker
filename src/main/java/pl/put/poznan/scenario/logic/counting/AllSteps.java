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

    /**
     * Counts a number of all steps in scenario.
     * It 'visits' every step and increments counter variable when
     * called by acceptCounting function in Step class object.
     *
     * @param step      currently visited step
     */
    public void count(Step step)
    {
        stepsNumber++;
    }

    /**
     * Sets stepsNumber variable to zero.
     * Must be called after counting to reset the value.
     *
     */
    public void afterCounting()
    {
        stepsNumber = 0;
    }
}
