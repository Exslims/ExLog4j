package com.home.exlog4j.parsers;

import com.home.exlog4j.config.ExConfig;

import java.util.HashMap;


public class PropertiesConfigParser implements Parser {

    private HashMap<String, ExConfig> configs = new HashMap<String, ExConfig>();
    public HashMap<String, ExConfig> getConfigs(String path) {
        return null;
    }
}
