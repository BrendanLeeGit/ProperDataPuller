package org.example.json;

import java.io.IOException;
import java.nio.file.Path;

/**
 * Used to read a JSON File and clean it up (I.e. removing whitespace) for easier processing.
 */
public class FileReader {
    public static String getStringOfFile(String filePath) {
        try {
            String fileStuff = java.nio.file.Files.readString(Path.of(filePath));
            fileStuff = removeExtraWhiteSpaces(fileStuff);
            fileStuff = fileStuff.replace("\n", "");
            return fileStuff;
            //return removeExtraWhiteSpaces(java.nio.file.Files.readString(Path.of(filePath)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String removeExtraWhiteSpaces(String jsonString) {
        StringBuilder result = new StringBuilder(jsonString.length());
        boolean inQuotes = false;
        boolean escapeMode = false;
        for (char character : jsonString.toCharArray()) {
            if (escapeMode) {
                result.append(character);
                escapeMode = false;
            } else if (character == '"') {
                inQuotes = !inQuotes;
                result.append(character);
            } else if (character == '\\') {
                escapeMode = true;
                result.append(character);
            } else if (!inQuotes && character == ' ') {
                continue;
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }
}
