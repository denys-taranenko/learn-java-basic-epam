package com.epam.java.basics.module_7_abstract_classes_and_interfaces.task_3_figures_extra_challenge;

class Triangle extends Figure {
    private final Point firstPoint;
    private final Point secondPoint;
    private final Point thirdPoint;

    public Triangle(Point firstPoint, Point secondPoint, Point thirdPoint) {
        if (firstPoint == null || secondPoint == null || thirdPoint == null) throw new IllegalArgumentException();

        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.thirdPoint = thirdPoint;

        if (area() == 0) throw new IllegalArgumentException();
    }

    @Override
    public Point centroid() {
        double xCentroid = (firstPoint.x()+ secondPoint.x()+ thirdPoint.x())/3;
        double yCentroid = (firstPoint.y()+ secondPoint.y()+ thirdPoint.y())/3;

        return new Point(xCentroid, yCentroid);
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (figure instanceof Triangle other) {
            return arePointsEqual(other);
        } else {
            return false;
        }
    }

    private double roundTo3DecimalPlace(double value) {
        return Math.round(value * 1000.0) / 1000.0;
    }

    private boolean arePointsEqual(Triangle A) {
        double counter = 3;
        Point[] aPoints = {A.firstPoint, A.secondPoint, A.thirdPoint};
        Point[] bPoints = {firstPoint, secondPoint, thirdPoint};

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
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

    private double area() {
        return firstPoint.x()* (secondPoint.y() - thirdPoint.y()) +
                secondPoint.x() * (thirdPoint.y() - firstPoint.y()) +
                thirdPoint.x() * (firstPoint.y() - secondPoint.y());
    }
}