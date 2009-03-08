package com.yoursway.jyp.tests;

import static junit.framework.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.yoursway.jyp.JSON;
import com.yoursway.jyp.JSON.SyntaxError;

public class JsonDecodingTests {
    
    @Test
    public void singleNull() throws SyntaxError {
        assertEquals(null, JSON.decode("null"));
    }
    
    @Test
    public void singleBoolean() throws SyntaxError {
        assertEquals(Boolean.TRUE, JSON.decode("true"));
        assertEquals(Boolean.FALSE, JSON.decode("false"));
    }
    
    @Test
    public void singleNumber() throws SyntaxError {
        assertEquals(42, JSON.decode("42"));
        assertEquals(-6, JSON.decode("-6"));
        assertEquals(3435435435435435l, JSON.decode("3435435435435435"));
        assertEquals(42.2d, JSON.decode("42.2"));
        assertEquals(42e120d, JSON.decode("42e120"));
    }
    
    @Test
    public void singleString() throws SyntaxError {
        assertEquals("abc", JSON.decode("\"abc\""));
        assertEquals("abc", JSON.decode("abc"));
        assertEquals("", JSON.decode("\"\""));
    }
    
    @Test
    public void escaping() throws SyntaxError {
        assertEquals("'", JSON.decode("\"'\""));
        assertEquals("\"", JSON.decode("\"\\\"\""));
        assertEquals("\n", JSON.decode("\"\\n\""));
        assertEquals("\r", JSON.decode("\"\\r\""));
        assertEquals("\t", JSON.decode("\"\\t\""));
        assertEquals("\0", JSON.decode("\"\\u0000\""));
    }
    
    @Test
    public void array() throws SyntaxError {
        List<?> list = (List<?>) JSON.decode("[10,\"Foo\",45.4]");
        assertEquals(3, list.size());
        assertEquals(10, list.get(0));
        assertEquals("Foo", list.get(1));
        assertEquals(45.4d, list.get(2));
    }
    
    @Test
    public void emptyArray() throws SyntaxError {
        assertEquals(0, ((List<?>) JSON.decode("[]")).size());
    }
    
    @Test
    public void map() throws SyntaxError {
        Map<?, ?> map = (Map<?, ?>) JSON.decode("{\"x\":10,\"y\":11,\"zzz\":12}");
        assertEquals(3, map.size());
        assertEquals(10, map.get("x"));
        assertEquals(11, map.get("y"));
        assertEquals(12, map.get("zzz"));
    }
    
    @Test
    public void emptyMap() throws SyntaxError {
        assertEquals(0, ((Map<?, ?>) JSON.decode("{}")).size());
    }
    
}
