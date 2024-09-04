package com.epam.java.basics.module_7_abstract_classes_and_interfaces.task_2_figures;

class Quadrilateral extends Figure {
    private final Point firstApex;
    private final Point secondApex;
    private final Point thirdApex;
    private final Point fourthApex;

    public Quadrilateral(Point firstApex, Point secondApex, Point thirdApex, Point fourthApex) {
        this.firstApex = firstApex;
        this.secondApex = secondApex;
        this.thirdApex = thirdApex;
        this.fourthApex = fourthApex;
    }

    @Override
    public double area() {
        double x1 = firstApex.x(), y1 = firstApex.y();
        double x2 = secondApex.x(), y2 = secondApex.y();
        double x3 = thirdApex.x(), y3 = thirdApex.y();
        double x4 = fourthApex.x(), y4 = fourthApex.y();

        return 0.5 * Math.abs(x1*y2 + x2*y3 + x3*y4 + x4*y1 - (y1*x2 + y2*x3 + y3*x4 + y4*x1));
    }

    @Override
    public String pointsToString() {
        return "(" + firstApex.x() + "," + firstApex.y() + ")"
                + "(" + secondApex.x() + "," + secondApex.y() + ")"
                + "(" + thirdApex.x() + "," + thirdApex.y() + ")"
                + "(" + fourthApex.x() + "," + fourthApex.y() + ")";
    }

    @Override
    public Point leftmostPoint() {
        Point[] points = {firstApex, secondApex, thirdApex, fourthApex};
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