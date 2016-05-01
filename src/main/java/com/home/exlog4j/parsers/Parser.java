package com.home.exlog4j.parsers;

import com.home.exlog4j.config.ExConfig;

import java.util.HashMap;


public interface Parser {
    HashMap<String, ExConfig> getConfigs(String path);
}
