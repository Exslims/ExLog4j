package com.home.exlog4j.parsers.properties;

import com.home.exlog4j.config.ExConfig;
import com.home.exlog4j.parsers.Parser;

import java.util.HashMap;

/**
 * Implementation of {@link Parser} that used to parse configuration represented by property file
 */
public class PropertiesConfigParser implements Parser {

    private HashMap<String, ExConfig> configs = new HashMap<>();
    public HashMap<String, ExConfig> getConfigs(String path) {
        return null;
    }
}
