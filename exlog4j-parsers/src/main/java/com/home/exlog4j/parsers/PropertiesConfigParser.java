package com.home.exlog4j.parsers;

import com.home.exlog4j.config.ExConfig;
import com.home.exlog4j.Parser;

import java.util.HashMap;

/**
 * Created by Константин on 21.02.2016.
 */
public class PropertiesConfigParser implements Parser {

    private HashMap<String, ExConfig> configs = new HashMap<String, ExConfig>();
    public HashMap<String, ExConfig> getConfigs(String path) {
        return null;
    }
}
