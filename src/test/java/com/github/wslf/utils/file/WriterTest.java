package com.github.wslf.utils.file;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Wsl_F
 */
public class WriterTest {

    public WriterTest() {
    }

    private void assertText(String expected, String real) {
        assertTrue(real.startsWith(expected));
        assertTrue(real.substring(expected.length()).matches("\\s*"));
    }

    @Test
    public void testWrite() {

        Reader reader = new Reader();
        Writer writer = new Writer();

        String fileName = "testFiles/testwrite1.txt";

        String expectedText = "";
        writer.write(expectedText, fileName);
        String realText = reader.getString(fileName);

        assertText(expectedText, realText);

        expectedText = "This is test text for write method.";
        writer.write(expectedText, fileName);
        realText = reader.getString(fileName);
        assertText(expectedText, realText);

    }

}
