package pl.put.poznan.scenario.logic.displaying;

import pl.put.poznan.scenario.model.Step;

/**
 * Visitor design pattern is applied in this application to display steps of scenario.
 * DisplayingVisitor is an abstract class created for this purpose.
 *
 * @author Anna Lubawa
 */
abstract public class DisplayingVisitor
{
    public abstract void display(Step step, String parentNum, int level);
    public abstract void afterDisplaying();
}
