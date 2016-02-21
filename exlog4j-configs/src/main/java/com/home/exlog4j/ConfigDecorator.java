package com.home.exlog4j;

/**
 * Created by Константин on 21.02.2016.
 */
public class ConfigDecorator {
    private ExConfig config;

    public ConfigDecorator(ExConfig config) {
        this.config = config;
    }

    public String getFormattedMessage(String message){
       return "";
    }

    public String getProfileName(){
        return "";
    }
}
