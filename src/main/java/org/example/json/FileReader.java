package org.example.json;

import java.io.IOException;
import java.nio.file.Path;

/**
 * Used to read a JSON File and clean it up (I.e. removing whitespace) for easier processing.
 */
public class FileReader {
    public static String getStringOfFile(String filePath) {
        try {
            return java.nio.file.Files.readString(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
