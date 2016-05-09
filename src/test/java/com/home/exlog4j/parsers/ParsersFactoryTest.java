package com.home.exlog4j.parsers;

import com.home.exlog4j.parsers.json.JsonConfigParser;
import com.home.exlog4j.parsers.properties.PropertiesConfigParser;
import com.home.exlog4j.parsers.xml.XmlConfigParser;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParsersFactoryTest {
    @Test
    public void testGetXmlParser() throws Exception {
        assertTrue(ParsersFactory.getParser(ParsersType.XML) instanceof XmlConfigParser);
    }

    @Test
    public void testGetJsonParser() throws Exception {
        assertTrue(ParsersFactory.getParser(ParsersType.JSON) instanceof JsonConfigParser);
    }

    @Test
    public void testGetPropertiesParser() throws Exception {
        assertTrue(ParsersFactory.getParser(ParsersType.PROPERTIES) instanceof PropertiesConfigParser);
    }
}