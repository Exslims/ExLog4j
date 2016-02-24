package com.home.exlog4j.config.appenders;

import com.home.exlog4j.config.appenders.Appender;


public class ConsoleAppender extends Appender {
    public ConsoleAppender(String pattern) {
        super(pattern);
    }

    @Override
    public void sendMessage(String level,String message, String target) {
        if (!level.equals("OFF"))
            if (level.equals("FATAL") || level.equals("ERROR"))
                System.err.println(patternLayout.getFormattedMessage(level,message,target));
            else
                System.out.println(patternLayout.getFormattedMessage(level,message,target));
    }
}
