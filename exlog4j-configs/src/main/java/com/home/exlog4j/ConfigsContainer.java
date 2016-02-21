package com.home.exlog4j;

import java.util.HashMap;

/**
 * Created by Константин on 21.02.2016.
 */
public class ConfigsContainer {
    private static ConfigsContainer instance = new ConfigsContainer();
    private ConfigInitializer configInitializer = new ConfigInitializer();

    private HashMap<String,ConfigDecorator> configDecorators;

    private ConfigsContainer(){
        configDecorators = configInitializer.getConfigDecorators();
    }

    public static ConfigsContainer getInstance(){
        return instance;
    }

    public ConfigDecorator getConfigDecorator(String profileName){
        return configDecorators.get(profileName);
    }
}
