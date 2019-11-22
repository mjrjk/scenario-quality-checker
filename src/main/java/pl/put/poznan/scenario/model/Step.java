package pl.put.poznan.scenario.model;

import java.util.List;

public class Step {

    private Integer stepNum;
    private List<String> content;
    private List<Step> substeps;
    private List<Integer> returnPath;

    public Step() { }

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
