package com.home.exlog4j;

import com.home.exlog4j.config.ExConfig;
import com.home.exlog4j.parsers.Parser;

import java.util.HashMap;

public class ConfigInitializer {
    private Parser parser;

    public HashMap<String,ExConfig> getConfigs() {
        return new HashMap<>();
    }
}
