package com.home.exlog4j;

import com.home.exlog4j.config.appenders.Appender;
import com.home.exlog4j.config.appenders.console.ConsoleAppender;
import com.home.exlog4j.config.ExConfig;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Singleton object, which contains all {@link ExConfig}
 */
public class ConfigsContainer {
    private static ConfigsContainer instance = new ConfigsContainer();
    private ConfigInitializer configInitializer = new ConfigInitializer();

    /**
     * Map of configs, key is a profile name
     */
    private HashMap<String,ExConfig> configs;

    private ConfigsContainer(){
        configs = configInitializer.getConfigs();
    }

    public static ConfigsContainer getInstance(){
        return instance;
    }

    /**
     * Getting config by profile name from map
     * @param profileName profile name from configuration
     * @return config
     */
    public ExConfig getConfig(String profileName){
        if(!configs.isEmpty() && configs.get(profileName) != null) {
            return configs.get(profileName);
        }
        else return getDefaultConfig();
    }

    /**
     * Getting default config if there are no other.
     * They can not exist because custom configuration has errors or custom configuration doesn't exist
     * @return default config
     */
    private ExConfig getDefaultConfig(){
        final Appender consoleAppender = new ConsoleAppender("%date{yyyy-MM-dd HH:mm:ss} %level %target %- %message");
        consoleAppender.sendMessage(Level.ERROR.toString() ,
                "Unable to find or load configuration file, default configuration is loaded" , ConfigsContainer.class.getCanonicalName());
        return new ExConfig("TRACE",new ArrayList<Appender>(){{add(consoleAppender);}});
    }
}
