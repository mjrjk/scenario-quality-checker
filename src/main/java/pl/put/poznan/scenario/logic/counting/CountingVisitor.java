package pl.put.poznan.scenario.logic.counting;

import pl.put.poznan.scenario.model.Step;

/**
 * Visitor design pattern is applied in this application to count steps in scenario.
 * CountingVisitor is an abstract class created for this purpose.
 *
 * @author Anna Lubawa
 */
abstract public class CountingVisitor
{
    public abstract void count(Step step);
    public abstract void afterCounting();
}
