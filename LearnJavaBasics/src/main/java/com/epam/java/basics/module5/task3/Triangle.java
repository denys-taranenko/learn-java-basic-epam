package com.epam.java.basics.module5.task3;

import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Triangle {
    private final Point a;
    private final Point b;
    private final Point c;

    public Triangle(Point a, Point b, Point c) {
        if (a == null || b == null || c == null) {
            throw new IllegalArgumentException();
        }

        if (a.equals(b) || b.equals(c) || a.equals(c)) {
            throw new IllegalArgumentException();
        }

        double determinant = a.getX() * (b.getY() - c.getY()) +
                b.getX() * (c.getY() - a.getY()) +
                c.getX() * (a.getY() - b.getY());

        if (determinant == 0) {
            throw new IllegalArgumentException();
        }

        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double area() {
        double AB = sqrt(pow(b.getX() - a.getX(), 2) + pow(b.getY() - a.getY(), 2));
        double BC = sqrt(pow(c.getX() - b.getX(), 2) + pow(c.getY() - b.getY(), 2));
        double CA = sqrt(pow(a.getX() - c.getX(), 2) + pow(a.getY() - c.getY(), 2));

        double p = (AB + BC + CA) / 2;

        return sqrt(p * (p - AB) * (p - BC) * (p - CA));
    }

    public Point centroid(){
        double centroidX = (a.getX() + b.getX() + c.getX()) / 3;
        double centroidY = (a.getY() + b.getY() + c.getY()) / 3;

        return new Point(centroidX,centroidY);
    }

}