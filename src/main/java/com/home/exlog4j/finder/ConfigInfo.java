package com.home.exlog4j.finder;


import com.home.exlog4j.parsers.ParsersType;

/**
 * Configuration information witch contains
 * path to configuration file and parser type
 */
public class ConfigInfo {
    private String configPath;
    private ParsersType type;

    /**
     * Constructs new ConfigInfo instance
     * @param configPath path to configuration file
     * @param type target parser type
     */
    public ConfigInfo(String configPath , ParsersType type) {
        this.configPath = configPath;
        this.type = type;
    }

    /**
     * Gets the value of the config path property.
     * @return configuration path
     */
    public String getConfigPath() {
        return configPath;
    }

    /**
     * Gets the value of the parser type property.
     * @return parser type
     */
    public ParsersType getType() {
        return type;
    }
}
