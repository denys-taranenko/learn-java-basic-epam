package com.epam.java.basics.module_5_classes.task_3_triangle;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Triangle {
    private final Point a;
    private final Point b;
    private final Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;

        if (a.equals(b) || b.equals(c) || a.equals(c)) {
            throw new IllegalArgumentException();
        }

        if (area() == 0) {
            throw new IllegalArgumentException();
        }
    }

    public double area() {
        double x1 = a.x(), y1 = a.y();
        double x2 = b.x(), y2 = b.y();
        double x3 = c.x(), y3 = c.y();

        double AB = sqrt(pow(x2 - x1, 2) + pow(y2 - y1, 2));
        double BC = sqrt(pow(x3 - x2, 2) + pow(y3 - y2, 2));
        double CA = sqrt(pow(x1 - x3, 2) + pow(y1 - y3, 2));

        double p = (AB + BC + CA) / 2;

        return sqrt(p * (p - AB) * (p - BC) * (p - CA));
    }

    public Point centroid() {
        double xCentroid = (a.x() + b.x() + c.x()) / 3;
        double yCentroid = (a.y() + b.y() + c.y()) / 3;

        return new Point(xCentroid,yCentroid);
    }
}