package com.home.exlog4j.parsers.json;

import com.home.exlog4j.config.ExConfig;
import com.home.exlog4j.parsers.Parser;

import java.util.HashMap;

public class JsonConfigParser implements Parser {
    private HashMap<String, ExConfig> configs = new HashMap<String, ExConfig>();
    public HashMap<String, ExConfig> getConfigs(String path) {
        return null;
    }
}
