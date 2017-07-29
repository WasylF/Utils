package com.github.wslf.utils.file;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Wsl_F
 */
public class ReaderTest {

    public ReaderTest() {
    }

    @Test
    public void testGetLines1() throws URISyntaxException {

        System.out.println("test getLines 1");
        Reader reader = new Reader();

        String fileName = "testFiles/testRead1.txt";
        ArrayList<String> lines = reader.getLines(fileName);

        assertNotNull(lines);

        ArrayList<String> linesExpected
                = new ArrayList<>(Arrays.asList("first", "text", "document"));

        assertEquals(lines, linesExpected);
    }

    @Test
    public void testGetString() {

        Reader reader = new Reader();

        String fileName = "testFiles/testRead1.txt";
        String txt = reader.getString(fileName);
        String txtEpected = "first\ntext\ndocument";

        assertEquals(txtEpected, txt);
    }
}
