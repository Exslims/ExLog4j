package com.home.exlog4j.finder;


import com.home.exlog4j.parsers.ParsersType;

/**
 * Contains configuration information
 */
public class ConfigInfo {
    private String configPath;
    private ParsersType type;

    public ConfigInfo(String configPath , ParsersType type) {
        this.configPath = configPath;
        this.type = type;
    }

    public String getConfigPath() {
        return configPath;
    }

    public ParsersType getType() {
        return type;
    }
}
