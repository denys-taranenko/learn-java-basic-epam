package com.epam.java.basics.module_13_enums.task_1_compass;

public enum Direction {
    N(0), NE(45), E(90), SE(135), S(180), SW(225), W(270), NW(315);

    Direction(final int degrees) {
        this.degrees = degrees;
    }

    private final int degrees;
    private static final int DEGREE_360 = 360;
    private static final int DEGREE_180 = 180;

    public int getDegrees() {
        return degrees;
    }

    public static Direction ofDegrees(int degrees) {
        degrees = (degrees % DEGREE_360 + DEGREE_360) % DEGREE_360;

        for (Direction direction : Direction.values()) {
            if (direction.getDegrees() == degrees) {
                return direction;
            }
        }
        return null;
    }

    public static Direction closestToDegrees(int degrees) {
        degrees = (degrees % DEGREE_360 + DEGREE_360) % DEGREE_360;

        Direction closestDirection = null;
        int minDifference = Integer.MAX_VALUE;

        for (Direction direction : Direction.values()) {
            int difference = Math.abs(degrees - direction.getDegrees());
            difference = Math.min(difference, DEGREE_360 - difference);

            if (difference < minDifference) {
                minDifference = difference;
                closestDirection = direction;
            }
        }
        return closestDirection;
    }

    public Direction opposite() {
        int currentDegrees = this.getDegrees();
        int oppositeDegrees = (currentDegrees + DEGREE_180) % DEGREE_360;

        for (Direction direction : Direction.values()) {
            if (direction.getDegrees() == oppositeDegrees) {
                return direction;
            }
        }
        return null;
    }

    public int differenceDegreesTo(Direction direction) {
        int currentDegree = this.getDegrees();
        int anotherDegree = direction.getDegrees();

        int difference = Math.abs(currentDegree - anotherDegree);

        if (currentDegree > anotherDegree) {
            difference = currentDegree - anotherDegree;
        } else {
            difference = anotherDegree - currentDegree;
        }

        return Math.min(difference, DEGREE_360 - difference);
    }
}