package com.epam.java.basics.module_9_working_with_strings.task_3_validations_epam_email;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EpamEmailValidation {

    public static boolean validateEpamEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }

        Pattern pattern = Pattern.compile("\\w+_\\w+@epam.com");
        Matcher matcher = pattern.matcher(email);

        return matcher.find();
    }
}