package com.epam.java.basics.module_21_introduction_to_i_o_streams.task_2_сipher_сreator;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;

import static com.epam.java.basics.module_21_introduction_to_i_o_streams.task_2_сipher_сreator.CipherCreator.cipherText;

class CipherCreatorTest {

    private static final String SUCCESSFUL_FILE_PATH = "src/test/resources/successful.txt";
    private static final String INVALID_CHARACTER_FILE_PATH = "src/test/resources/invalid-characters.txt";
    private static final String READABLE_FILE_PATH = "src/test/resources/readable.txt";
    private static final String NON_EXISTENT_FILE_PATH = "src/test/resources/no-file.txt";
    private static final String DIRECTORY_FILE_PATH = "src/test/resources";

    @Test
    void shouldReturnSuccessfullyCipheredText() {
        // given
        File inputFile = new File(SUCCESSFUL_FILE_PATH);
        String expected = "Vguv\nekrjgt\nHqt\nHwpfcogpvcnu\nQh\nRtqitcookpi\nZAB\nbaz\nEcognEcug\nFkUeQ";

        // when
        StringBuilder result = cipherText(inputFile);

        // then
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result.toString());
    }

    @Test
    void shouldReturnFilteredCipheredText() {
        // given
        File inputFile = new File(INVALID_CHARACTER_FILE_PATH);
        String expected = "Jk\n\n";

        // when
        StringBuilder result = cipherText(inputFile);

        // then
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result.toString());
    }

    @Test
    void shouldReturnDirectoryException() {
        // given
        File inputFile = new File(DIRECTORY_FILE_PATH);

        // when-then
        Assertions.assertThrows(IllegalArgumentException.class, () -> cipherText(inputFile));
    }

    @Test
    void shouldReturnNonExistentException() {
        // given
        File inputFile = new File(NON_EXISTENT_FILE_PATH);

        // when-then
        Assertions.assertThrows(IllegalArgumentException.class, () -> cipherText(inputFile));
    }

    @Disabled
    @Test
    void shouldReturnNotReadableException() {
        // given
        File inputFile = new File(READABLE_FILE_PATH);
        Assertions.assertTrue(inputFile.setReadable(true));

        // when-then
        Assertions.assertTrue(inputFile.setReadable(false));
        Assertions.assertThrows(IllegalArgumentException.class, () -> cipherText(inputFile));
    }

    @Test
    void shouldCheckAllMethodsAreOverride() {
        // given
        Class<?> clazz = TransformerInputStream.class;

        // when
        List<String> methodNames = Arrays.stream(clazz.getMethods())
                .filter(method -> TransformerInputStream.class
                        .equals(method.getDeclaringClass()))
                .map(Method::getName)
                .toList();

        // then
        Assertions.assertEquals(2, methodNames.size());
        Assertions.assertTrue(methodNames.contains("read"));
        Assertions.assertTrue(methodNames.contains("close"));
    }

    @AfterAll
    public static void tearDown() {
        File inputFile = new File(READABLE_FILE_PATH);
        Assertions.assertTrue(inputFile.setReadable(true));
    }
}
