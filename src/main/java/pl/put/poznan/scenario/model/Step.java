package pl.put.poznan.scenario.model;

import pl.put.poznan.scenario.logic.counting.CountingVisitor;
import java.util.List;

/**
 * Step class represents a single step in a scenario.
 *
 */
public class Step
{
    private Integer stepNum;
    private List<String> content;
    private List<Step> substeps;
    private List<Integer> returnPath;

    public Step() { }

    public void acceptCounting(CountingVisitor visitor)
    {
        visitor.count(this);
        if(!this.substeps.isEmpty())
            for(Step step : substeps)
                step.acceptCounting(visitor);
    }

    public Integer getStepNum() {
        return stepNum;
    }

    public void setStepNum(Integer stepNum) {
        this.stepNum = stepNum;
    }

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
