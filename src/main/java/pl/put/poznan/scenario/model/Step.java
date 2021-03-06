package pl.put.poznan.scenario.model;

import pl.put.poznan.scenario.logic.counting.CountingVisitor;
import pl.put.poznan.scenario.logic.displaying.DisplayingVisitor;

import java.util.List;

/**
 * Step class represents a single step in a scenario.
 *
 */
public class Step
{
    private Integer stepNum;
    private String actor;
    private List<String> content;
    private List<Step> substeps;
    private List<Integer> returnPath;

    public Step() { }

    /**
     * Accepts counting by visitor object.
     *
     * @param visitor       object visiting steps of scenario
     */
    public void acceptCounting(CountingVisitor visitor)
    {
        visitor.count(this);
        if(!this.substeps.isEmpty())
            for(Step step : substeps)
                step.acceptCounting(visitor);
    }

    /**
     * Accepts displaying by visitor object.
     *
     * @param visitor       object visiting steps of scenario
     */
    public void acceptDisplaying(DisplayingVisitor visitor, String num, int level)
    {
        num += "<strong>" + this.stepNum + ".</strong>";
        visitor.display(this, num, level);
        if(!this.substeps.isEmpty()) {
            level++;
            for (Step step : substeps)
                step.acceptDisplaying(visitor, num, level);
        }
    }

    public Integer getStepNum() {
        return stepNum;
    }

    public void setStepNum(Integer stepNum) {
        this.stepNum = stepNum;
    }

    public String getActor() { return actor; }

    public void setActor(String actor) { this.actor = actor; }

    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }

    public List<Step> getSubsteps() {
        return substeps;
    }

    public void setSubsteps(List<Step> substeps) {
        this.substeps = substeps;
    }

    public List<Integer> getReturnPath() {
        return returnPath;
    }

    public void setReturnPath(List<Integer> returnPath) {
        this.returnPath = returnPath;
    }
}
