package com.epam.java.basics.module_21_introduction_to_i_o_streams.task_1_license_reader;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class LicenseReaderTest {

    private LicenseReader licenseReader;

    @BeforeEach
    void setUp() {
        licenseReader = new LicenseReader();
    }

    @Test
    @DisplayName("Neither rootDirectory or outputFile might be null")
    void testThatNullsAreUnacceptable() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> licenseReader.collectLicenses(null, new File(""))),
                () -> assertThrows(IllegalArgumentException.class, () -> licenseReader.collectLicenses(new File(""), null))
        );
    }

    @Test
    @DisplayName("rootDirectory must exists, be readable and traversable")
    void testThatRootDirectoryIsCorrect() {
        assertAll(
                () -> {
                    var root = mock(File.class);
                    when(root.exists()).thenReturn(false);
                    assertThrows(IllegalArgumentException.class, () -> licenseReader.collectLicenses(root, new File("")));
                },
                () -> {
                    var root = mock(File.class);
                    when(root.exists()).thenReturn(true);
                    when(root.isDirectory()).thenReturn(false);
                    assertThrows(IllegalArgumentException.class, () -> licenseReader.collectLicenses(root, new File("")));
                },
                () -> {
                    var root = mock(File.class);
                    when(root.exists()).thenReturn(true);
                    when(root.isDirectory()).thenReturn(true);
                    when(root.canExecute()).thenReturn(false);
                    assertThrows(IllegalArgumentException.class, () -> licenseReader.collectLicenses(root, new File("")));
                },
                () -> {
                    var root = mock(File.class);
                    when(root.exists()).thenReturn(true);
                    when(root.isDirectory()).thenReturn(true);
                    when(root.canExecute()).thenReturn(true);
                    when(root.canRead()).thenReturn(false);
                    assertThrows(IllegalArgumentException.class, () -> licenseReader.collectLicenses(root, new File("")));
                }
        );
    }

    @ParameterizedTest(name = "For file {0} must be thrown IllegalArgumentException")
    @ValueSource(strings = {
            "incomplete_headers",
            "invalid_end_headers",
            "missing_issued_by",
            "missing_issued_on",
            "missing_license_name"
    })
    @DisplayName("Invalid license files must not be processed")
    void invalidLicensesTest(String fileName) {
        var directory = getDirectory("invalid_licenses");
        var file = new File(directory, fileName);
        assertThrows(IllegalArgumentException.class,
                () -> licenseReader.collectLicenses(file, new File(directory, "output")));
    }

    @ParameterizedTest(name = "For directory {0} expected file content is {2}")
    @MethodSource
    @DisplayName("Positive test cases")
    void test(File rootDirectory, File outputFile, File expectedFile) {
        licenseReader.collectLicenses(rootDirectory, outputFile);
        try {
            Stream<String> actualLines = Files.readAllLines(outputFile.toPath()).stream().sorted();
            Stream<String> expectedLines = Files.readAllLines(expectedFile.toPath()).stream().sorted();
            assertLinesMatch(expectedLines, actualLines);
        } catch (IOException e) {
            throw new Error(e);
        }
    }

    static Stream<Arguments> test() {
        return IntStream.rangeClosed(1, 4)
                .mapToObj(i -> String.format("case_%02d", i))
                .map(LicenseReaderTest::argsForCase);
    }

    private static Arguments argsForCase(String caseName) {
        File root = getDirectory(caseName);
        Random random = new Random(System.currentTimeMillis());
        File input = new File(root, "input");
        File expected = new File(root, "expected");
        File output = new File(root, "output-" + random.nextInt());
        return arguments(input, output, expected);
    }

    private static File getDirectory(String path) {
        URL url = LicenseReaderTest.class.getClassLoader().getResource(path);
        if (url == null) {
            throw new IllegalStateException();
        }
        try {
            return new File(url.toURI());
        } catch (URISyntaxException e) {
            throw new IllegalStateException(e);
        }
    }
}
