package com.home.exlog4j.config.appenders;

import com.home.exlog4j.config.appenders.Appender;

/**
 * Created by Константин on 23.02.2016.
 */
public class ConsoleAppender extends Appender {
    public ConsoleAppender(String pattern) {
        super(pattern);
    }

    @Override
    public void sendMessage(String level,String message, String target) {
        System.out.println(patternLayout.getFormattedMessage(level,message,target));
    }
}
