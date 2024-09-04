package com.epam.java.basics.module_5_classes.task_2_segments;

public class Main {
    public static void main(String[] args) {

        {
            double length = new Segment(new Point(0, 0), new Point(3, 4)).length();
            System.out.println(length);
        }

        {
            Segment first = new Segment(new Point(0, 0), new Point(4, 4));
            Segment second = new Segment(new Point(2, 0), new Point(0, 2));
            Point intersection = first.intersection(second);

            System.out.println(intersection.x());
            System.out.println(intersection.y());
        }

        {
            Segment first = new Segment(new Point(0, 0), new Point(4, 0));
            Segment second = new Segment(new Point(2, 1), new Point(1, 2));
            Point intersection = first.intersection(second);

            System.out.println(intersection == null);
        }

        {
            Segment segment = new Segment (new Point (2, 0), new Point (0, 2));
            Point midpoint = segment.middle();

            System.out.println(midpoint.x());
            System.out.println(midpoint.y());
        }
    }
}