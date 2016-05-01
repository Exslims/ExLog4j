package com.home.exlog4j.parsers;

import com.home.exlog4j.config.ExConfig;

import java.util.HashMap;

/**
 * Base polymorphic interface for all parsers class.
 */
public interface Parser {
    /**
     * By path gets configuration file and parse him. Building and returning map of {@link ExConfig} with key like profile name.
     * @param path path to configuration file
     * @return map of {@link ExConfig}
     */
    HashMap<String, ExConfig> getConfigs(String path);
}
