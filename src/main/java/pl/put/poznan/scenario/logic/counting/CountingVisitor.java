package pl.put.poznan.scenario.logic.counting;

import pl.put.poznan.scenario.model.Step;

import java.util.List;

abstract public class CountingVisitor
{
    public abstract int count(List<Step> steps);
}
