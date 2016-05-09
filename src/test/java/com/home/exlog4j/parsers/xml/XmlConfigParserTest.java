package com.home.exlog4j.parsers.xml;

import com.home.exlog4j.config.ExConfig;
import com.home.exlog4j.parsers.Parser;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.HashMap;


public class XmlConfigParserTest {

    @Test
    public void testGetConfigs() throws Exception {
        Parser parser = new XmlConfigParser();
        HashMap<String , ExConfig> configHashMap = parser.getConfigs("exlog4j-config.xml");
        TestCase.assertNotNull(configHashMap);
    }
}