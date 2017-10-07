package com.github.wslf.utils.file;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Writer class is class for simplifying writing to text files.
 *
 * @author Wsl_F
 */
public class Writer {

    /**
     * Writes list of the lines to the text file.
     *
     * @param lines lines to be written
     * @param fileName absolute or relative path to the text file to be
     * overwritten or created
     * @param eoln end of line. For example:
     * <li>"\r\n" for windows </li>
     * <li> "\n" for linux </li>
     *
     * @return successfulness of writing to the file
     */
    public boolean write(ArrayList<String> lines, String fileName, String eoln) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName))) {
            for (String line : lines) {
                writer.write(line);
                writer.write(eoln);
            }
            return true;
        } catch (Exception ex) {
            System.err.println(ex);
            return false;
        }
    }

    /**
     * Writes list of the lines to the text file.
     *
     * @param lines lines to be written
     * @param fileName absolute or relative path to the text file to be
     * overwritten or created
     *
     * @return successfulness of writing to the file
     */
    public boolean write(ArrayList<String> lines, String fileName) {
        return write(lines, fileName, "\r\n");
    }

    /**
     * Writes list of the lines to the text file.
     *
     * @param text lines to be written
     * @param fileName absolute or relative path to the text file to be
     * overwritten or created
     *
     * @return successfulness of writing to the file
     */
    public boolean write(String text, String fileName) {
        return write(new ArrayList<>(Arrays.asList(text)), fileName);
    }

}
