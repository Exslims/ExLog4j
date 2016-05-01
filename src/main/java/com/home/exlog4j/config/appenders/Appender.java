package com.home.exlog4j.config.appenders;


/**
 * Base class for all appender
 */
public abstract class Appender {
    protected PatternLayout patternLayout;

    public Appender(String pattern){
        patternLayout = new PatternLayout(pattern);
    }

    public abstract void sendMessage(String level, String message, String target);

    public PatternLayout getPatternLayout() {
        return patternLayout;
    }

    public void setPatternLayout(PatternLayout patternLayout) {
        this.patternLayout = patternLayout;
    }

}
