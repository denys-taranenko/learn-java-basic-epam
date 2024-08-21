package com.epam.java.basics.module5.task1;

public class Line {
    private final int k;
    private final int b;

    public Line(int k, int b) {
        this.k = k;
        this.b = b;
    }

    public Point intersection(Line other) {
        if (this.k == other.k) {
            return null;
        }

        int x = (other.b - this.b) / (this.k - other.k);
        int y = this.k * x + this.b;

        return new Point(x,y);
    }
}