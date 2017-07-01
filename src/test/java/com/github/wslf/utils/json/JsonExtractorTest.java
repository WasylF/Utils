package com.github.wslf.utils.json;

import org.json.JSONObject;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 *
 * @author Wsl_F
 */
public class JsonExtractorTest {

    private final JSONObject testObject;

    public JsonExtractorTest() {
        testObject = new JSONObject();
        testObject.put("String", "stringValue");
        testObject.put("Integer", 0);
        testObject.put("Long", 1_000_000_000_000L);
        testObject.put("Double", "3.14");
        testObject.put("Boolean", true);
    }

    /**
     * Test of getString method, of class JsonExtractor.
     */
    @Test
    public void testGetString() {
        System.out.println("getString");
        String name = "String";
        JsonExtractor instance = new JsonExtractor();
        String expResult = "stringValue";
        String result = instance.getString(testObject, name);
        assertEquals(expResult, result);
    }

    /**
     * Test of getInt method, of class JsonExtractor.
     */
    @Test
    public void testGetInt() {
        System.out.println("getInt");
        String name = "Integer";
        JsonExtractor instance = new JsonExtractor();
        Integer expResult = 0;
        Integer result = instance.getInt(testObject, name);
        assertEquals(expResult, result);
    }

    /**
     * Test of getLong method, of class JsonExtractor.
     */
    @Test
    public void testGetLong() {
        System.out.println("getLong");
        String name = "Long";
        JsonExtractor instance = new JsonExtractor();
        Long expResult = 1_000_000_000_000L;
        Long result = instance.getLong(testObject, name);
        assertEquals(expResult, result);
    }

    /**
     * Test of getBoolean method, of class JsonExtractor.
     */
    @Test
    public void testGetBoolean() {
        System.out.println("getBoolean");
        String name = "Boolean";
        JsonExtractor instance = new JsonExtractor();
        Boolean expResult = true;
        Boolean result = instance.getBoolean(testObject, name);
        assertEquals(expResult, result);
    }

    /**
     * Test of getDouble method, of class JsonExtractor.
     */
    @Test
    public void testGetDouble() {
        System.out.println("getDouble");
        String name = "Double";
        JsonExtractor instance = new JsonExtractor();
        Double expResult = 3.14;
        Double result = instance.getDouble(testObject, name);
        assertEquals(expResult, result, 1e-6);
    }

    @Test
    public void testNulls() {
        System.out.println("testNulls");
        JsonExtractor instance = new JsonExtractor();
        Object result;

        result = instance.getBoolean(testObject, "smth");
        assertNull(result);

        result = instance.getInt(testObject, "Boolean");
        assertNull(result);
    }

    @Test
    public void testSetters() {
        System.out.println("testSetters");
        JsonExtractor instance = new JsonExtractor();

        instance.setDefaultBooleanValue(Boolean.FALSE);
        Boolean resultBoolean = instance.getBoolean(testObject, "smth");
        assertFalse(resultBoolean);

        instance.setDefaultIntegerValue(-5);
        Integer resultInteger = instance.getInt(testObject, "Boolean");
        assertNotNull(resultInteger);
        assertEquals((int) resultInteger, -5);

        Integer expResult = 0;
        Integer result = instance.getInt(testObject, "Integer");
        assertEquals(expResult, result);

    }

}
