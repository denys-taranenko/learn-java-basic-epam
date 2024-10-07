package com.epam.java.basics.module_23_nio_2.task_1_file_tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class FileTreeTest {

    @Test
    void testEmptyCases() {
        assertTrue(new FileTree().tree(null).isEmpty(), "null case failure");
        assertTrue(new FileTree().tree(Paths.get("some", " non", "existent", "path")).isEmpty(),
                "nonexistent path case failure");
    }

    @Test
    void testFileCases() {
        testCase("some.txt 0 bytes", tree("test1", "some.txt"));
        testCase("some1.txt 4 bytes", tree("test1", "some1.txt"));
        testCase("some2.txt 8 bytes", tree("test1", "some2.txt"));
    }

    @Test
    void testDirCase1() throws IOException {
        testDirCase("test1");
    }

    @Test
    void testDirCase2() throws IOException {
        testDirCase("test2");
    }

    @Test
    void testDirCase3() throws IOException {
        testDirCase("test3");
    }

    @Test
    void testDirCase4() throws IOException {
        testDirCase("test4");
    }

    @Test
    void testDirCase5() throws IOException {
        testDirCase("test5");
    }

    @Test
    void testDirCase6() throws IOException {
        testDirCase("test6");
    }

    @Test
    void testDirCase7() throws IOException {
        testDirCase("test7");
    }

    @Test
    void testDirCase8() throws IOException {
        testDirCase("test8");
    }

    private void testDirCase(final String caseName) throws IOException {
        testCase(expectedFile(caseName), tree(caseName));
    }

    private void testCase(final String expected, final String actual) {
        assertEquals(expected.trim(), actual.trim());
    }

    private String expectedFile(String caseName) throws IOException {

        try (Stream<String> linesStream = Files.lines(Paths.get("src/test/resources", caseName + ".txt"))) {
            return linesStream.collect(Collectors.joining("\n"));
        }
    }

    private String tree(final String... subPath) {
        return new FileTree().tree(Paths.get("src/test/resources", subPath)).orElse(null);
    }
}
