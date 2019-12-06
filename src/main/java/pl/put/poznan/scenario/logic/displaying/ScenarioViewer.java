package pl.put.poznan.scenario.logic.displaying;

import pl.put.poznan.scenario.model.Step;

/**
 * ScenarioViewer class displays all steps in scenario.
 * It extends abstract class DisplayingVisitor and uses Visitor design pattern.
 *
 * @author Anna Lubawa
 */
public class ScenarioViewer extends DisplayingVisitor
{
    private String scenarioText = "";

    public String getScenarioText() {
        return scenarioText;
    }

    public void setScenarioText(String scenarioText) {
        this.scenarioText = scenarioText;
    }

    /**
     * Numbers every step of scenario and displays it.
     * It 'visits' a step when called by acceptDisplaying function in Step object
     *
     * @param step      currently visited step
     * @param parentNum number of parent step
     * @param level     level of substep; used to control text indentation
     */
    @Override
    public void display(Step step, String parentNum, int level)
    {
        for(int i=0; i<level; i++)
            scenarioText += "- - ";
        scenarioText += parentNum + " ";
        for(int i=0; i < step.getContent().size(); i++)
            scenarioText += step.getContent().get(i) + " ";
        scenarioText += "</br>";
    }

    /**
     * Sets scenarioText to empty string.
     * Must be called after displaying scenario with display function to reset the value.
     *
     */
    @Override
    public void afterDisplaying() {
        scenarioText = "";
    }
}
