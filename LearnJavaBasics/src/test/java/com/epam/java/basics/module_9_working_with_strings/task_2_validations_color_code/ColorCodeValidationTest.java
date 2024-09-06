package com.epam.java.basics.module_9_working_with_strings.task_2_validations_color_code;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.epam.java.basics.module_9_working_with_strings.task_2_validations_color_code.ColorCodeValidation.validateColorCode;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ColorCodeValidationTest {

    @ParameterizedTest(name = "{index} Hex \"{0}\" is invalid")
    @NullAndEmptySource
    @ValueSource(strings = {
            "123456",
            "#afafah",
            "#afafa",
            "#afafag",
            "#afzfax",
            "#123abce",
            "#1234",
            "#-123",
            " "
    })
    void validateHexInvalidCases(String input) {
        assertFalse(validateColorCode(input));
    }

    @ParameterizedTest(name = "{index} Hex \"{0}\" is valid")
    @ValueSource(strings = {
            "#000000",
            "#999999",
            "#1a1a1a",
            "#1A1A1A",
            "#0f0f0f",
            "#0F0F0F",
            "#bcbcbf",
            "#BcbCbC",
            "#000",
            "#FFF",
            "#abc"})
    void validateHexValidCases(String input) {
        assertTrue(validateColorCode(input));
    }
}