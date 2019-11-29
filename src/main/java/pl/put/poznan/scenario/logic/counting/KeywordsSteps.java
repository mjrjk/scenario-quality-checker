package pl.put.poznan.scenario.logic.counting;

import pl.put.poznan.scenario.model.Step;

import java.util.List;

/**
 * KeywordsSteps class counts steps containing keywords in scenario.
 * It extends abstract class CountingVisitor and uses Visitor design pattern.
 *
 * @author Anna Lubawa
 */
public class KeywordsSteps extends CountingVisitor
{
    private int stepsNumber = 0;

    public int getStepsNumber() { return stepsNumber; }

    /**
     * Counts a number of steps containing keywords.
     * It 'visits' every step and increments counter variable when
     * called by acceptCounting function in Step class object
     * only if given step contains keyword at the beginning.
     *
     * @param step      currently visited step
     */
    public void count(Step step)
    {
        if(isKeyword(step))
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

    /**
     * Checks if given step contains a keyword at the beginning.
     *
     * @param step      step to check
     * @return          true/false value depending on whether step contains a keyword or not
     */
    private static boolean isKeyword(Step step)
    {
        List<String> content = step.getContent();
        return content.get(0).equals("IF") || content.get(0).equals("FOR EACH") || content.get(0).equals("ELSE");
    }
}
