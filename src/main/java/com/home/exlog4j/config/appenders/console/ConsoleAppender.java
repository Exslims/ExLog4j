package com.home.exlog4j.config.appenders.console;

import com.home.exlog4j.config.appenders.Appender;

/**
 * Console appender for configuration. Writes on console log strings
 */
public class ConsoleAppender extends Appender {
    public ConsoleAppender(String pattern) {
        super(pattern);
    }

    /**
     * Send message to console
     * @param level log level
     * @param message message
     * @param target class where the method was called
     */
    @Override
    public void sendMessage(String level,String message, String target) {
        if (!level.equals("OFF"))
            if (level.equals("FATAL") || level.equals("ERROR"))
                System.err.println(patternLayout.getFormattedMessage(level,message,target));
            else
                System.out.println(patternLayout.getFormattedMessage(level,message,target));
    }
}
