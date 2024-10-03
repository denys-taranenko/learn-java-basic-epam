package com.epam.java.basics.module_21_introduction_to_i_o_streams.task_2_сipher_сreator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class CipherCreator {

    private CipherCreator() {
    }

    public static StringBuilder cipherText(File input) {
        if (input == null || !input.exists() || !input.canRead() || input.isDirectory()) {
            throw new IllegalArgumentException("Invalid file input.");
        }

        StringBuilder stringBuilder = new StringBuilder();

        try (TransformerInputStream transformerInputStream = new TransformerInputStream(new FileInputStream(input))) {
            int byteData;

            while ((byteData = transformerInputStream.read()) != -1) {
                stringBuilder.append((char) byteData);
            }

        } catch (IOException e) {
            throw new IllegalArgumentException("Error reading the file.", e);
        }

        return stringBuilder;
    }
}
