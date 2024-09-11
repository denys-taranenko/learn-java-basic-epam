package com.epam.java.basics.module_14_wrapper_classes.task_1_battleship8x8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Battleship8x8 {
    private final long ships;
    private long shots = 0L;

    public Battleship8x8(final long ships) {
        this.ships = ships;
    }

    public boolean shoot(String shot) {
        Pattern pattern = Pattern.compile("[A-Ha-h][1-8]");
        Matcher matcher = pattern.matcher(shot);
        if (!matcher.find()) {
            return false;
        }

        int column = Character.getNumericValue(shot.charAt(0)) - Character.getNumericValue('A');
        int row = Character.getNumericValue(shot.charAt(1)) - Character.getNumericValue('1');
        int index = 63 - (row * 8 + column);

        long mask = 1L << index;
        shots |= mask;

        return (ships & mask) != 0;
    }

    public String state() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {

                int index = 63 - (row * 8 + column);
                long mask = 1L << index;

                if ((shots & mask) != 0) {
                    if ((ships & mask) != 0) {
                        stringBuilder.append('☒');
                    } else {
                        stringBuilder.append('×');
                    }
                } else {
                    if ((ships & mask) != 0) {
                        stringBuilder.append('☐');
                    } else {
                        stringBuilder.append('.');
                    }
                }
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString().trim();
    }
}