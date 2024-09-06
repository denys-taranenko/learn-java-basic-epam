package com.epam.java.basics.module_9_working_with_strings.task_1_words;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringUtil {

    public static int countEqualIgnoreCaseAndSpaces(String[] words, String sample) {
        if (words == null || sample == null || words.length == 0) {
            return 0;
        }

        return (int) Arrays.stream(words)
                .filter(str -> str.trim().equalsIgnoreCase(sample.trim()))
                .count();
    }

    public static String[] splitWords(String text) {
        Pattern splitPattern = Pattern.compile("[,.;:\\s?!]+");

        if (text == null || text.isEmpty() || text.matches(splitPattern.pattern())) {
            return null;
        }

        String[] splitArray = text.trim().split(splitPattern.pattern());

        return Arrays.stream(splitArray)
                .filter(str -> !str.isEmpty())
                .toArray(String[]::new);
    }

    private static final Pattern[] ERROR_PATTERNS = {
            Pattern.compile("(?=(?:.*~){2,}).*$"),
            Pattern.compile("|(?=.*~)^(?!~).+$"),
            Pattern.compile("|(?=.*~)(?=.*\\\\).+$"),
            Pattern.compile("|(?=(?:.*[Cc]:){2,}).*$"),
            Pattern.compile("|(?=.*[Cc]:)^(?![Cc]:).+$"),
            Pattern.compile("|(?=.*[Cc]:)(?=.*/).*$"),
            Pattern.compile("|(?=.*\\\\)(?=.*/).*$"),
    };

    private static String convertToWindowsPath(String path) {
        switch (path) {
            case "~":
                return "C:\\User";
            case ".":
                return ".";
            case "..":
                return "..";
            case "/":
                return "C:\\";
        }

        String winPath = path.replace("/", "\\");

        if (winPath.startsWith("~\\")) {
            return "C:\\User" + winPath.substring(1);
        }

        if (winPath.startsWith("\\")) {
            return "C:\\" + winPath.substring(1);
        }

        return winPath;
    }

    private static String convertToUnixPath(String path) {
        switch (path) {
            case "C:\\User":
                return "~";
            case ".":
                return ".";
            case "..":
                return "..";
            case "C:\\":
                return "/";
        }

        String unixPath = path.replace("\\", "/");

        if (unixPath.startsWith("C:/User")) {
            return "~" + unixPath.substring(7);
        }

        if (unixPath.startsWith("C:/")) {
            return "/" + unixPath.substring(3);
        }

        return unixPath;
    }

    public static String convertPath(String path, boolean toWin) {
        return convertPath(path, toWin, 0); //Recursion
    }

    private static String convertPath(String path, boolean toWin, int currentIndex) {
        if (path == null || path.isEmpty()) {
            return null;
        }

        if (currentIndex >= ERROR_PATTERNS.length) {
            if (toWin) {
                return convertToWindowsPath(path);
            } else {
                return convertToUnixPath(path);
            }
        }

        if (ERROR_PATTERNS[currentIndex].matcher(path).matches()) {
            return null;
        } else {
            return convertPath(path, toWin, currentIndex + 1);
        }
    }

    public static String joinWords (String[]words){
        if (words == null || words.length == 0) {
            return null;
        }

        ArrayList<String> arrayList = new ArrayList<>();

        for (String word : words) {
            if (!word.isEmpty()) {
                arrayList.add(word);
            }
        }

        if (arrayList.isEmpty()) {
            return null;
        }

        return arrayList.stream().collect(Collectors.joining(", ", "[", "]"));
    }
}