package com.home.exlog4j.config;

/**
 * Created by Константин on 23.02.2016.
 */
public abstract class Appender {
    protected PatternLayout patternLayout;
    public Appender(String pattern){
        patternLayout = new PatternLayout(pattern);
    }

    public abstract void sendMessage(String message);

    public PatternLayout getPatternLayout() {
        return patternLayout;
    }

    public void setPatternLayout(PatternLayout patternLayout) {
        this.patternLayout = patternLayout;
    }
}
