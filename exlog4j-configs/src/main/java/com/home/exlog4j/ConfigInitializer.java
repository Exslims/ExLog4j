package com.home.exlog4j;

import com.home.exlog4j.config.ExConfig;

import java.util.HashMap;

/**
 * Created by Константин on 21.02.2016.
 */
public class ConfigInitializer {
    private Parser parser;

    public HashMap<String,ExConfig> getConfigs() {
        return new HashMap<String, ExConfig>();
    }
}
