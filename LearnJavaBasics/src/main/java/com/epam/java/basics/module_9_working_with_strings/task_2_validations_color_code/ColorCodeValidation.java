package com.epam.java.basics.module_9_working_with_strings.task_2_validations_color_code;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorCodeValidation {
    public static boolean validateColorCode(String color) {
        if (color == null || color.isEmpty()) {
            return false;
        }

        Pattern pattern = Pattern.compile("^#([a-fA-F0-9]{6}|[a-fA-F0-9]{3})$");
        Matcher matcher = pattern.matcher(color);

        return color.startsWith("#") && matcher.find();
    }
}