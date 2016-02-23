package com.home.exlog4j;

import com.home.exlog4j.config.Appender;
import com.home.exlog4j.config.ConsoleAppender;
import com.home.exlog4j.config.ExConfig;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Константин on 21.02.2016.
 */
public class ConfigsContainer {
    private static ConfigsContainer instance = new ConfigsContainer();
    private ConfigInitializer configInitializer = new ConfigInitializer();

    private HashMap<String,ExConfig> configs;

    private ConfigsContainer(){
        configs = configInitializer.getConfigs();
    }

    public static ConfigsContainer getInstance(){
        return instance;
    }

    public ExConfig getConfig(String profileName){
        if(configs.size() != 0 && configs.get(profileName) != null) {
            return configs.get(profileName);
        }
        else return getDefaultConfig();
    }

    private ExConfig getDefaultConfig(){
        final Appender consolAppender = new ConsoleAppender("%date{yyyy-MM-dd HH:mm:ss} %level %target:position %- %message");
        return new ExConfig("TRACE",new ArrayList<Appender>(){{add(consolAppender);}});
    }
}
