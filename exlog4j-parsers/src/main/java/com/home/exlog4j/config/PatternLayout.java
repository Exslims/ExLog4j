package com.home.exlog4j.config;

import java.text.SimpleDateFormat;

/**
 * %date{yyyy-MM-dd HH:mm:ss} %level %target:position %- %message
 */
public class PatternLayout {
    private String pattern;

    private SimpleDateFormat dateFormat;

    public PatternLayout(String pattern) {
        this.pattern = pattern;

        parse();
    }

    private void parse() {
        String[] tokens = pattern.split("%");
    }

    public String getFormattedMessage(String token){
        return "";
    }

    public String getPattern() {
        return pattern;
    }
}
