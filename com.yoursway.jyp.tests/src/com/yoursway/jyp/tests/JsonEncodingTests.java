package com.yoursway.jyp.tests;

import static junit.framework.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.yoursway.jyp.JSON;

public class JsonEncodingTests {
    
    @Test
    public void singleNull() {
        assertEquals("null", JSON.encode(null));
    }
    
    @Test
    public void singleBoolean() {
        assertEquals("true", JSON.encode(true));
        assertEquals("false", JSON.encode(false));
        assertEquals("true", JSON.encode(Boolean.TRUE));
        assertEquals("false", JSON.encode(Boolean.FALSE));
    }
    
    @Test
    public void singleInteger() {
        assertEquals("42", JSON.encode(42));
        assertEquals("42", JSON.encode(42));
        assertEquals("0", JSON.encode(0));
        assertEquals("-6", JSON.encode(-6));
    }
    
    @Test
    public void singleLong() {
        assertEquals("42", JSON.encode(42l));
        assertEquals("42", JSON.encode(42l));
        assertEquals("0", JSON.encode(0l));
        assertEquals("-6", JSON.encode(-6l));
    }
    
    @Test
    public void singleByte() {
        assertEquals("42", JSON.encode((byte) 42));
        assertEquals("42", JSON.encode((byte) 42));
        assertEquals("0", JSON.encode((byte) 0));
        assertEquals("-6", JSON.encode((byte) -6));
    }
    
    @Test
    public void singleShort() {
        assertEquals("42", JSON.encode((short) 42));
        assertEquals("42", JSON.encode((short) 42));
        assertEquals("0", JSON.encode((short) 0));
        assertEquals("-6", JSON.encode((short) -6));
    }
    
    @Test
    public void singleFloat() {
        assertEquals("42.5", JSON.encode(42.5f));
        assertEquals("42.5", JSON.encode(42.5f));
        assertEquals("42", JSON.encode(42.0f));
        assertEquals("42.12", JSON.encode(42.12f));
    }
    
    @Test
    public void singleDouble() {
        assertEquals("42.5", JSON.encode(42.5d));
        assertEquals("42.5", JSON.encode(42.5d));
        assertEquals("42", JSON.encode(42.0d));
        assertEquals("42.12", JSON.encode(42.12d));
    }
    
    @Test
    public void singleCharacter() {
        assertEquals("\"a\"", JSON.encode('a'));
        assertEquals("\"a\"", JSON.encode('a'));
    }
    
    @Test
    public void singleString() {
        assertEquals("\"abc\"", JSON.encode("abc"));
        assertEquals("\"\"", JSON.encode(""));
    }
    
    @Test
    public void escaping() {
        assertEquals("\"'\"", JSON.encode("'"));
        assertEquals("\"\\\"\"", JSON.encode("\""));
        assertEquals("\"\\n\"", JSON.encode("\n"));
        assertEquals("\"\\r\"", JSON.encode("\r"));
        assertEquals("\"\\t\"", JSON.encode("\t"));
        assertEquals("\"\\u0000\"", JSON.encode("\0"));
    }
    
    @Test
    public void list() {
        List<Object> c = new ArrayList<Object>();
        c.add(10);
        c.add("Foo");
        c.add(45.4);
        assertEquals("[10,\"Foo\",45.4]", JSON.encode(c));
    }
    
    @Test
    public void emptyList() {
        assertEquals("[]", JSON.encode(new ArrayList<Object>()));
    }
    
    @Test
    public void array() {
        Object[] c = new Object[] { 10, "Foo", 45.4 };
        assertEquals("[10,\"Foo\",45.4]", JSON.encode(c));
    }
    
    @Test
    public void emptyArray() {
        assertEquals("[]", JSON.encode(new Object[0]));
    }
    
    @Test
    public void map() {
        Map<Object, Integer> c = new HashMap<Object, Integer>();
        c.put("x", 10);
        c.put("y", 11);
        c.put("zzz", 12);
        assertEquals("{\"x\":10,\"y\":11,\"zzz\":12}", JSON.encode(c));
    }
    
    @Test
    public void emptyMap() {
        assertEquals("{}", JSON.encode(new HashMap<Object, Object>()));
    }
    
}
