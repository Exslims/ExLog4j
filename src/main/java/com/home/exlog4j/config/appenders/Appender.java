package com.home.exlog4j.config.appenders;


/**
 * Base abstract class for all appender implementations
 */
public abstract class Appender {
    protected PatternLayout patternLayout;

    /**
     * Constructs new Appender instance
     * @param pattern logging pattern for {@link PatternLayout}
     */
    public Appender(String pattern){
        patternLayout = new PatternLayout(pattern);
    }

    /**
     * Sends message into appender
     * @param level  message level
     * @param message message object
     * @param target target class
     */
    public abstract void sendMessage(String level, String message, String target);

    /**
     * Gets specific pattern layout for this appender
     * @return
     */
    public PatternLayout getPatternLayout() {
        return patternLayout;
    }

    /**
     * Sets pattern layout property
     * @param patternLayout
     */
    public void setPatternLayout(PatternLayout patternLayout) {
        this.patternLayout = patternLayout;
    }

}
