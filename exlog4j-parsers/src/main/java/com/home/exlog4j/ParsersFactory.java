package com.home.exlog4j;

import com.home.exlog4j.parsers.JsonConfigParser;
import com.home.exlog4j.parsers.PropertiesConfigParser;
import com.home.exlog4j.parsers.XmlConfigParser;

public class ParsersFactory {
    private Parser xmlParser = new XmlConfigParser();
    private Parser jsonParser = new JsonConfigParser();
    private Parser propertiesParser = new PropertiesConfigParser();

    public Parser getXmlParser() {
        return xmlParser;
    }

    public Parser getJsonParser() {
        return jsonParser;
    }

    public Parser getPropertiesParser() {
        return propertiesParser;
    }
}
