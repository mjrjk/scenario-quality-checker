package pl.put.poznan.scenario.model;

import pl.put.poznan.scenario.logic.counting.CountingVisitor;

import java.util.List;

public class Scenario
{
    private String title;
    private List<String> actors;
    private List<String> sysactors;
    private List<Step> steps;

    public Scenario() { }

    public int acceptCounting(CountingVisitor visitor)
    {
        return visitor.count(this.getSteps());
        /*
        for(Step step : steps) {
            step.acceptCounting(visitor);
        }
        */
    }

    public String getTitle() {
        return title;
    }

    public List<String> getActors() {
        return actors;
    }

    public List<String> getSysactors() {
        return sysactors;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    public void setSysactors(List<String> sysactors) {
        this.sysactors = sysactors;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }
}
