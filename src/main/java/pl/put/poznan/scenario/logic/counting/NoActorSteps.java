package pl.put.poznan.scenario.logic.counting;

import pl.put.poznan.scenario.model.Step;

/**
 * NoActorSteps class counts steps in a scenario that have no actor assigned.
 * It extends abstract class CountingVisitor and uses Visitor design pattern.
 *
 * @author Anna Lubawa
 */
public class NoActorSteps extends CountingVisitor
{
    private int stepsNumber = 0;

    public int getStepsNumber() {
        return stepsNumber;
    }

    /**
     * Counts a number of steps in a scenario that have no actor assigned.
     * It 'visits' every step and increments counter variable when
     * called by acceptCounting function in Step class object.
     *
     * @param step      currently visited step
     */
    public void count(Step step)
    {
        if(!isActor(step))
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

    private boolean isActor(Step step) {
        if(!step.getActor().equals(""))
            return true;

        return false;
    }
}