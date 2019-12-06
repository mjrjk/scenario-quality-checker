package pl.put.poznan.scenario.logic.displaying;

import pl.put.poznan.scenario.model.Step;

public class ScenarioLevelViewer extends DisplayingVisitor
{
    private String scenarioText = "";
    private int desiredLevel = 0;

    public ScenarioLevelViewer(int desiredLevel) { this.desiredLevel = desiredLevel; }

    public String getScenarioText() {
        return scenarioText;
    }

    public void setScenarioText(String scenarioText) {
        this.scenarioText = scenarioText;
    }

    public int getDesiredLevel() {
        return desiredLevel;
    }

    public void setDesiredLevel(int desiredLevel) {
        this.desiredLevel = desiredLevel;
    }

    /**
     * Numbers steps of scenario and displays it,
     * but only to certain level specified by private variable named desiredLevel,
     * which is assigned value in class constructor or in the setter function.
     * It 'visits' a step when called by acceptDisplaying function in Step object.
     *
     * @param step      currently visited step
     * @param parentNum number of parent step
     * @param level     level of substep; used to control text indentation
     */
    @Override
    public void display(Step step, String parentNum, int level)
    {
        if(level < desiredLevel) {
            for (int i = 0; i < level; i++)
                scenarioText += "- - ";
            scenarioText += parentNum + " ";
            for (int i = 0; i < step.getContent().size(); i++)
                scenarioText += step.getContent().get(i) + " ";
            scenarioText += "</br>";
        }
    }

    /**
     * Sets scenarioText to empty string.
     * Must be called after displaying scenario with display function to reset the value.
     *
     */
    @Override
    public void afterDisplaying()
    {
        scenarioText = "";
        desiredLevel = 0;
    }
}
