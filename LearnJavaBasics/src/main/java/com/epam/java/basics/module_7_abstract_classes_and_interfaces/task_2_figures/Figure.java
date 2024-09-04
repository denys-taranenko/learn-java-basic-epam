package com.epam.java.basics.module_7_abstract_classes_and_interfaces.task_2_figures;

abstract class Figure {

    public abstract double area();

    public abstract String pointsToString();

    public String toString() {
        return this.getClass().getSimpleName() + "[" + pointsToString() + "]";
    }

    public abstract Point leftmostPoint();
}