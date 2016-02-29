package com.home.exlog4j.parsers;

import com.home.exlog4j.ParsersFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParsersFactoryTest {
    private ParsersFactory factory;
    @Before
    public void before(){
        factory = new ParsersFactory();
    }
    @Test
    public void testGetXmlParser() throws Exception {
        assertTrue(factory.getXmlParser() instanceof XmlConfigParser);
    }

    @Test
    public void testGetJsonParser() throws Exception {
        assertTrue(factory.getJsonParser() instanceof JsonConfigParser);
    }

    @Test
    public void testGetPropertiesParser() throws Exception {
        assertTrue(factory.getPropertiesParser() instanceof PropertiesConfigParser);
    }
}