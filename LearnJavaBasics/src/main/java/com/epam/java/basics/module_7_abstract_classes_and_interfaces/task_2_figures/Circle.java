package com.epam.java.basics.module_7_abstract_classes_and_interfaces.task_2_figures;

import static java.lang.Math.pow;
import static java.lang.Math.PI;

class Circle extends Figure {
    private final Point centerPoint;
    private final double radius;

    public Circle(Point centerPoint, double radius) {
        this.centerPoint = centerPoint;
        this.radius = radius;
    }

    @Override
    public double area() {
        return PI * pow(radius, 2);
    }

    @Override
    public String pointsToString() {
        return "(" + centerPoint.x() + "," + centerPoint.y() + ")";
    }

    @Override
    public Point leftmostPoint() {
        return new Point(centerPoint.x() - radius, centerPoint.y());
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[" + pointsToString() + radius + "]";
    }
}