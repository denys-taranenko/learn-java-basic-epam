package com.epam.java.basics.module_7_abstract_classes_and_interfaces.task_2_figures;

public class Main {
    public static void main(String[] args) {
        double area;

        area = new Triangle(new Point(0, 0), new Point(3, 0), new Point(0, 4)).area();
        System.out.println(area);

        area = new Quadrilateral(new Point(1, 0), new Point(2, 1), new Point(1, 2), new Point(0, 1)).area();
        System.out.println(area);

        area = new Circle(new Point(1, 1), 3).area();
        System.out.println(area);

    }
}