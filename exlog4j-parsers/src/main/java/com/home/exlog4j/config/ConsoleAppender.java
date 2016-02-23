package com.home.exlog4j.config;

/**
 * Created by Константин on 23.02.2016.
 */
public class ConsoleAppender extends Appender {
    public ConsoleAppender(String pattern) {
        super(pattern);
    }

    @Override
    public void sendMessage(String message) {
        System.out.println(patternLayout.getFormattedMessage(message));
    }
}
