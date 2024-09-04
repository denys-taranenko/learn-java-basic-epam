package com.epam.java.basics.module_7_abstract_classes_and_interfaces.task_3_figures_extra_challenge;

import static java.lang.Math.*;

class Circle extends Figure {

    private final Point center;
    private final double radius;

    public Circle(Point center, double radius) {
        if (radius <= 0 || center == null) throw new IllegalArgumentException();

        this.center = center;
        this.radius = radius;

        if (area() == 0) throw new IllegalArgumentException();
    }

    @Override
    public Point centroid() {
        return center;
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (figure instanceof Circle otherCircle) {
            return roundTo2DecimalPlace(center.x())
                    == roundTo2DecimalPlace(otherCircle.center.x())
                    && roundTo2DecimalPlace(center.y())
                    == roundTo2DecimalPlace(otherCircle.center.y())
                    && roundTo2DecimalPlace(radius)
                    == roundTo2DecimalPlace(otherCircle.radius);
        } else {
            return false;
        }
    }

    private double roundTo2DecimalPlace(double value) {
        return Math.round(value * 1000.0) / 1000.0;
    }

    private double area() {
        return PI * pow(radius, 2);
    }
}