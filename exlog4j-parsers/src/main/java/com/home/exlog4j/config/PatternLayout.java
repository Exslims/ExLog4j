package com.home.exlog4j.config;

/**
 * Created by Константин on 23.02.2016.
 */
public class PatternLayout {
    private String pattern;

    public PatternLayout(String pattern) {
        this.pattern = pattern;
    }

    public String getFormattedMessage(String token){
        return "";
    }

    public String getPattern() {
        return pattern;
    }
}
