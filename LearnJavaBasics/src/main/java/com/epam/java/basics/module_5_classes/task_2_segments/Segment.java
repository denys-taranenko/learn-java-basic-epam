package com.epam.java.basics.module_5_classes.task_2_segments;

import static java.lang.Math.sqrt;
import static java.lang.StrictMath.min;
import static java.lang.StrictMath.max;
import static java.lang.StrictMath.pow;

class Segment {
    private final Point start;
    private final Point end;

    public Segment(Point start, Point end) {
        this.start = start;
        this.end = end;

        if (start.x() == end.x() && start.y() == end.y()) {
            throw new IllegalArgumentException();
        }
    }

    double length() {
        return sqrt(pow(end.x() - start.x(), 2) + pow(end.y() - start.y(), 2));
    }

    Point middle() {
        double xMidPoint = (start.x() + end.x()) / 2;
        double yMidPoint = (start.y() + end.y()) / 2;

        return new Point(xMidPoint,yMidPoint);
    }

    Point intersection(Segment another) {
        double x1 = start.x(), y1 = start.y();
        double x2 = end.x(), y2 = end.y();
        double x3 = another.start.x(), y3 = another.start.y();
        double x4 = another.end.x(), y4 = another.end.y();

        double determinants = (((x1 - x2) * (y3 - y4)) - ((y1 - y2) * (x3 - x4)));

        if (determinants == 0) {
            return null;
        }

        double xIntersection = ((((x1 * y2) - (y1 * x2)) * (x3 - x4)) - ((x1 - x2) * ((x3 * y4) - (y3 * x4))))
                / determinants;
        double yIntersection = ((((x1 * y2) - (y1 * x2)) * (y3 - y4)) - ((y1 - y2) * ((x3 * y4) - (y3 * x4))))
                / determinants;

        boolean firstSegment = (min(x1,x2) <= xIntersection && xIntersection <= max(x1,x2)
                && min(y1,y2) <= yIntersection && yIntersection <= max(y1,y2));
        boolean secondSegment = (min(x3,x4) <= xIntersection && xIntersection <= max(x3,x4)
                && min(y3,y4) <= yIntersection && yIntersection <= max(y3,y4));

        if (firstSegment && secondSegment) {
            return new Point(xIntersection,yIntersection);
        } else {
            return null;
        }
    }
}