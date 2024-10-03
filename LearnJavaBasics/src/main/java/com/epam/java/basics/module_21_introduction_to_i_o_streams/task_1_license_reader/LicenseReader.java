package com.epam.java.basics.module_21_introduction_to_i_o_streams.task_1_license_reader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LicenseReader {
    private static final String START_OF_LICENSE = "---";
    private static final String SEPARATOR = ":";
    private static final int SPACE_COUNT = 1;

    public void collectLicenses(File root, File outputFile) {
        dataValidation(root, outputFile);

        if (outputFile.exists() && outputFile.canWrite()) {
            clearOutputFile(outputFile);
        }

        checkRoot(root, outputFile);
    }

    private void dataValidation(File root, File outputFile) {
        if (root == null || outputFile == null) {
            throw new IllegalArgumentException("ROOT directory or OUTPUT file cannot be NULL");
        }

        if (!root.exists() || !root.canRead()) {
            throw new IllegalArgumentException("ROOT directory DOES NOT EXIST or CANNOT BE READ");
        }

        if (root.isDirectory() && !root.canExecute()) {
            throw new IllegalArgumentException("ROOT directory IS NOT EXECUTED");
        }
    }

    private void clearOutputFile(File outputFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, false))) {
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private void checkRoot(File root, File outputFile) {
        if (root.isFile()) {
            checkFile(root, outputFile);
        } else if (root.isDirectory()) {
            File[] files = root.listFiles();
            if (files != null) {
                for (File file : files) {
                    checkRoot(file, outputFile);
                }
            }
        }
    }

    private void checkFile(File file, File outputFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String currentLine = reader.readLine();

            if (!currentLine.trim().equals(START_OF_LICENSE)) {
                return;
            }

            String fileName = file.getName();
            String licenseName = null;
            String issuedOn = null;
            String issuedBy = null;
            String expiresOn = "unlimited";

            String lastNonEmptyLine = currentLine;

            while (currentLine != null) {

                if (!currentLine.isEmpty()) {
                    lastNonEmptyLine = currentLine;
                }

                String separatorString = currentLine.substring(currentLine.indexOf(SEPARATOR) + SPACE_COUNT).trim();
                if (currentLine.startsWith("License:")) {
                    licenseName = separatorString;
                } else if (currentLine.startsWith("Issued on:")) {
                    issuedOn = separatorString;
                } else if (currentLine.startsWith("Issued by:")) {
                    issuedBy = separatorString;
                } else if (currentLine.startsWith("Expires on:")) {
                    expiresOn = separatorString;
                }
                currentLine = reader.readLine();
            }

            if (!lastNonEmptyLine.equals(START_OF_LICENSE)) {
                throw new IllegalArgumentException();
            }

            if (licenseName == null || issuedOn == null || issuedBy == null) {
                throw new IllegalArgumentException();
            } else {
                buildLicenses(fileName, licenseName, issuedOn, issuedBy, expiresOn, outputFile);
            }

        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private void buildLicenses(String fileName, String licenseName, String issuedOn,
                               String issuedBy, String expiresOn, File outputFile) {

        String formatLicense = "License for " + fileName + " is "
                                + licenseName + " issued by " + issuedBy
                                + " [" + issuedOn + " - " + expiresOn + "]";

        writeLicenseToFile(formatLicense, outputFile);
    }

    private void writeLicenseToFile(String license, File outputFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, true))) {
            writer.write(license);
            writer.newLine();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
