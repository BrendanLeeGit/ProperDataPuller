package org.example.json;

import java.io.IOException;
import java.nio.file.Path;

/**
 * Just used to take data from a JSON File and clean it up. I'm putting this here because it's ugly and I don't
 * want to see it.
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
