package com.epam.java.basics.module_21_introduction_to_i_o_streams.task_2_сipher_сreator;

import java.io.IOException;
import java.io.InputStream;

public class TransformerInputStream extends InputStream {
    private final InputStream inputStream;

    public TransformerInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public int read() throws IOException {
        int byteData;

        while ((byteData = inputStream.read()) != -1) {
            char character = (char) byteData;

            if (Character.isLetter(character)) {
                return cipherCharacter(character);
            } else if (character == '\n') {
                return '\n';
            }
        }

        return -1;
    }

    private int cipherCharacter(char character) {
        char base = Character.isUpperCase(character) ? 'A' : 'a';
        return (character - base + 2) % 26 + base;
    }

    @Override
    public void close() throws IOException {
        inputStream.close();
        System.out.println("Stream closed.");
    }
}
