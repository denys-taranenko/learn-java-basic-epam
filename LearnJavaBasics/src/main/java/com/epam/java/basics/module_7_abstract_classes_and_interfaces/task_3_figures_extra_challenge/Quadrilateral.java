package com.epam.java.basics.module_7_abstract_classes_and_interfaces.task_3_figures_extra_challenge;

import static java.lang.Math.*;

class Quadrilateral extends Figure {
    private final Point firstPoint;
    private final Point secondPoint;
    private final Point thirdPoint;
    private final Point fourthPoint;

    public Quadrilateral(Point firstPoint, Point secondPoint, Point thirdPoint, Point fourthPoint) {
        if (firstPoint == null || secondPoint == null || thirdPoint == null || fourthPoint == null)
            throw new IllegalArgumentException();

        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.thirdPoint = thirdPoint;
        this.fourthPoint = fourthPoint;

        if (length(firstPoint, secondPoint) == 0 || length(secondPoint, thirdPoint) == 0
                || length(thirdPoint, firstPoint) == 0 || length(firstPoint, fourthPoint) == 0)
            throw new IllegalArgumentException();

        if (area() == 0) throw new IllegalArgumentException();
        if (checkDirectionalFactors(firstPoint, secondPoint, thirdPoint)) throw new IllegalArgumentException();
        if (checkDirectionalFactors(secondPoint, thirdPoint, fourthPoint)) throw new IllegalArgumentException();

        double[][] points = {
                {firstPoint.x(), firstPoint.y()},
                {secondPoint.x(), secondPoint.y()},
                {thirdPoint.x(), thirdPoint.y()},
                {fourthPoint.x(), fourthPoint.y()}
        };
        if (!isConvex(points)) throw new IllegalArgumentException();
    }

    @Override
    public Point centroid() {
        Point centroidOfTriangle1 = centroidOfTriangle(firstPoint, secondPoint, thirdPoint);
        Point centroidOfTriangle2 = centroidOfTriangle(firstPoint, thirdPoint, fourthPoint);
        Point centroidOfTriangle3 = centroidOfTriangle(firstPoint, secondPoint, fourthPoint);
        Point centroidOfTriangle4 = centroidOfTriangle(thirdPoint, secondPoint, fourthPoint);

        return getIntersectionPoint(centroidOfTriangle1, centroidOfTriangle2, centroidOfTriangle3, centroidOfTriangle4);
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (figure instanceof Quadrilateral other) {
            return arePointsEqual(other);
        } else {
            return false;
        }
    }

    private double roundTo3DecimalPlace(double value) {
        return Math.round(value * 1000.0) / 1000.0;
    }

    private boolean arePointsEqual(Quadrilateral A) {
        double counter = 4;
        Point[] aPoints = {A.firstPoint, A.secondPoint, A.thirdPoint, A.fourthPoint};
        Point[] bPoints = {firstPoint, secondPoint, thirdPoint, fourthPoint};

        for (int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                if (roundTo3DecimalPlace(aPoints[i].x())
                        == roundTo3DecimalPlace(bPoints[j].x())
                        && roundTo3DecimalPlace(aPoints[i].y())
                        == roundTo3DecimalPlace(bPoints[j].y())) {
                    counter--;
                }
            }
        }
        return counter <= 0;
    }

    private Point getIntersectionPoint(Point A, Point B, Point C, Point D) {
        double a1 = B.y() - A.y();
        double b1 = A.x() - B.x();

        double c1 = a1 * (A.x()) + b1 * (A.y());

        double a2 = D.y() - C.y();
        double b2 = C.x() - D.x();

        double c2 = a2 * (C.x())+ b2 * (C.y());

        double determinant = a1 * b2 - a2 * b1;
        double x = (b2 * c1 - b1 * c2) / determinant;
        double y = (a1 * c2 - a2 * c1) / determinant;

        return new Point(x, y);
    }

    private Point centroidOfTriangle(Point A, Point B, Point C) {
        return new Point((A.x() + B.x() + C.x()) / 3,(A.y() + B.y() + C.y()) / 3);
    }

    private double length(Point A, Point B) {
        return sqrt(pow(B.x() - A.x(), 2) + pow(B.y() - A.y(), 2));
    }

    private double areaOfTriangle(Point A,Point B, Point C) {
        return A.x() * (B.y() - C.y()) +
               B.x() * (C.y() - A.y()) +
               C.x() * (A.y() - B.y());
    }

    private double area() {
        return areaOfTriangle(firstPoint, secondPoint, thirdPoint) + areaOfTriangle(firstPoint, thirdPoint, fourthPoint);
    }

    private boolean checkDirectionalFactors(Point x1,Point x2,Point x3) {
        double directionalFactor1 = (x2.y() - x1.y()) / (x2.x() - x1.x());
        double directionalFactor2 = (x3.y() - x1.y()) / (x3.x() - x1.x());

        return directionalFactor1 == directionalFactor2;
    }

    private double CrossProduct(double[][] A) {
        double x1 = (A[1][0] - A[0][0]);
        double y1 = (A[1][1] - A[0][1]);
        double x2 = (A[2][0] - A[0][0]);
        double y2 = (A[2][1] - A[0][1]);

        return (x1 * y2 - y1 * x2);
    }

    private boolean isConvex(double[][] points) {
        int n = points.length;

        double prev = 0;
        double curr = 0;

        for (int i = 0; i < n; i++) {
            double[][] temp = { points[i], points[(i + 1) % n], points[(i + 2) % n] };
            curr = CrossProduct(temp);
            if (curr != 0) {
                if (curr * prev < 0) {
                    return false;
                } else {
                    prev = curr;
                }
            }
        }
        return true;
    }
}