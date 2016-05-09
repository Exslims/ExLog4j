package com.home.exlog4j;

import com.home.exlog4j.config.ExConfig;
import com.home.exlog4j.finder.ConfigFinder;
import com.home.exlog4j.finder.ConfigInfo;
import com.home.exlog4j.finder.ConfigNotFoundException;
import com.home.exlog4j.parsers.Parser;
import com.home.exlog4j.parsers.ParsersFactory;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Optional;

/**
 *
 */
public class ConfigInitializer {

    private HashMap<String , ExConfig> configHashMap;

    /**
     *
     * @return HashMap of configuration files
     */
    public HashMap<String,ExConfig> getConfigs() {
        this.configHashMap = new LinkedHashMap<>();
        Optional<ConfigInfo> infoOptional = this.findConfiguration();
        infoOptional.ifPresent((configInfo -> {
            Parser targetParser = ParsersFactory.getParser(configInfo.getType());
            configHashMap = targetParser.getConfigs(configInfo.getConfigPath());
        }));
        return configHashMap;
    }

    /**
     *
     * @return optional value of configuration info
     */
    private Optional<ConfigInfo> findConfiguration() {
        ConfigInfo configInfo = null;
        try {
            configInfo = new ConfigFinder().findConfiguration();
        } catch (ConfigNotFoundException e) {
            /*NOP*/
        }
        return Optional.ofNullable(configInfo);
    }

}
