package com.epam.java.basics.module_5_classes.task_1_line_intersection;

public class Line {
    private final int k;
    private final int b;

    public Line(int k, int b) {
        this.k = k;
        this.b = b;
    }

    public Point intersection(Line other) {
        if (k == other.k ) {
            return null;
        }

        int xIntersection = (other.b - b) / (k - other.k);
        int yIntersection = (k * xIntersection) + b;

        return new Point(xIntersection, yIntersection);
    }
}