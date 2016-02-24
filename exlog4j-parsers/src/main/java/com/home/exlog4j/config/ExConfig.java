package com.home.exlog4j.config;

import com.home.exlog4j.config.appenders.Appender;

import java.util.List;

/**
 * Created by Константин on 21.02.2016.
 */
public class ExConfig {
    private String logLevel;
    private List<Appender> appenderList;

    public ExConfig(String logLevel, List<Appender> appenderList) {
        this.logLevel = logLevel;
        this.appenderList = appenderList;
    }

    public ExConfig(String logLevel) {
        this.logLevel = logLevel;
    }

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    public List<Appender> getAppenderList() {
        return appenderList;
    }

    public void setAppenderList(List<Appender> appenderList) {
        this.appenderList = appenderList;
    }
    public void addAppender(Appender appender){
        appenderList.add(appender);
    }
}
