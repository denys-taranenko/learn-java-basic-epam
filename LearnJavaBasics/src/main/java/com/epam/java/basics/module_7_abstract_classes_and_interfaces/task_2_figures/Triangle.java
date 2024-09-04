package com.epam.java.basics.module_7_abstract_classes_and_interfaces.task_2_figures;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

class Triangle extends Figure {
    private final Point firstApex;
    private final Point secondApex;
    private final Point thirdApex;

    public Triangle(Point firstApex, Point secondApex, Point thirdApex) {
        this.firstApex = firstApex;
        this.secondApex = secondApex;
        this.thirdApex = thirdApex;
    }

    @Override
    public double area() {
        double sideA = sqrt(pow(secondApex.x() - firstApex.x(), 2) + pow(secondApex.y() - firstApex.y(), 2));
        double sideB = sqrt(pow(thirdApex.x() - secondApex.x(), 2) + pow(thirdApex.y() - secondApex.y(), 2));
        double sideC = sqrt(pow(firstApex.x() - thirdApex.x(), 2) + pow(firstApex.y() - thirdApex.y(), 2));

        double halfPerimeter = (sideA + sideB + sideC) / 2;

        return sqrt(halfPerimeter * ((halfPerimeter - sideA) * (halfPerimeter - sideB) * (halfPerimeter - sideC)));
    }

    @Override
    public String pointsToString() {
        return "(" + firstApex.x() + "," + firstApex.y() + ")"
                + "(" + secondApex.x() + "," + secondApex.y() + ")"
                + "(" + thirdApex.x() + "," + thirdApex.y() + ")";
    }

    @Override
    public Point leftmostPoint() {
        Point[] points = {firstApex, secondApex, thirdApex};
        Point leftmost = points[0];

        for (int i = 1; i < points.length; i++) {
            if (points[i].x() < leftmost.x() ||
                    (points[i].x() == leftmost.x() && points[i].y() < leftmost.y())) {
                leftmost = points[i];
            }
        }
        return leftmost;
    }
}