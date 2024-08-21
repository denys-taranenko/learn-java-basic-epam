package com.epam.java.basics.module5.task2;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;


class Segment {
    private final Point start;
    private final Point end;

    public Segment(Point start, Point end) {
        if (start.getX() == end.getX() && start.getY() == end.getY()) {
            throw new IllegalArgumentException();
        }

        this.start = start;
        this.end = end;
    }

    double length() {
        return sqrt(pow(end.getX() - start.getX(), 2) + pow(end.getY() - start.getY(), 2));
    }

    Point middle() {
        double middleX = (start.getX() + end.getX()) / 2;
        double middleY = (start.getY() + end.getY()) / 2;

        return new Point(middleX,middleY);
    }

    Point intersection(Segment another) {
        double x1 = start.getX(), y1 = start.getY();
        double x2 = end.getX(), y2 = end.getY();
        double x3 = another.start.getX(), y3 = another.start.getY();
        double x4 = another.end.getX(), y4 = another.end.getY();

        double A1 = y2 - y1;
        double B1 = x1 - x2;
        double C1 = A1 * x1 + B1 * y1;

        double A2 = y4 - y3;
        double B2 = x3 - x4;
        double C2 = A2 * x3 + B2 * y3;

        double det = A1 * B2 - A2 * B1;

        if (abs(det) < 1e-10) {
            return null;
        }

        double intersectX = (B2 * C1 - B1 * C2) / det;
        double intersectY = (A1 * C2 - A2 * C1) / det;
        Point intersectionPoint = new Point(intersectX, intersectY);


        boolean onFirstSegment = (Math.min(start.getX(), end.getX()) <= intersectX && intersectX <= Math.max(start.getX(), end.getX()))
                && (Math.min(start.getY(), end.getY()) <= intersectY && intersectY <= Math.max(start.getY(), end.getY()));

        boolean onSecondSegment = (Math.min(x3, x4) <= intersectX && intersectX <= Math.max(x3, x4))
                && (Math.min(y3, y4) <= intersectY && intersectY <= Math.max(y3, y4));


        if (onFirstSegment && onSecondSegment) {
            return intersectionPoint;
        } else {
            return null;
        }
    }
}