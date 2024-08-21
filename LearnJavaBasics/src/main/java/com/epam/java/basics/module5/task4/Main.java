package com.epam.java.basics.module5.task4;

public class Main {
    public static void main(String[] args) {

        CarouselRun run = new DecrementingCarousel(7).run();
        System.out.println(run.isFinished());
        System.out.println(run.next());

        DecrementingCarousel carousel=new DecrementingCarousel(7);

        carousel.addElement(2);
        carousel.addElement(3);
        carousel.addElement(1);

        CarouselRun run1 = carousel.run();

        System.out.println(run1.isFinished());

        System.out.println(run1.next());
        System.out.println(run1.next());
        System.out.println(run1.next());

        System.out.println(run1.next());
        System.out.println(run1.next());
        System.out.println(run1.next());

        System.out.println(run1.isFinished());
        System.out.println(run1.next());

        DecrementingCarousel carousel1 = new DecrementingCarousel(3);

        System.out.println(carousel1.addElement(-2));
        System.out.println(carousel1.addElement(0));

        System.out.println(carousel1.addElement(2));
        System.out.println(carousel1.addElement(3));
        System.out.println(carousel1.addElement(1));

        System.out.println(carousel1.addElement(2));

        CarouselRun run2 = carousel1.run();

        System.out.println(run2.next());
        System.out.println(run2.next());
        System.out.println(run2.next());

        System.out.println(run2.next());
        System.out.println(run2.next());

        System.out.println(run2.next());

        System.out.println(run2.isFinished());
        System.out.println(run2.next());

        DecrementingCarousel carousel2 = new DecrementingCarousel(10);

        System.out.println(carousel2.addElement(2));
        System.out.println(carousel2.addElement(3));
        System.out.println(carousel2.addElement(1));

        carousel2.run();

        System.out.println(carousel2.addElement(2));
        System.out.println(carousel2.addElement(3));
        System.out.println(carousel2.addElement(1));

        DecrementingCarousel carousel3 = new DecrementingCarousel(10);
        System.out.println(carousel3.run() == null);
        System.out.println(carousel3.run() == null);
    }
}
