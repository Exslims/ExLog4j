package com.home.exlog4j.config.appenders;

import com.home.exlog4j.config.appenders.Appender;

public class FileAppender extends Appender {
    private String fileName;
    private String maxFileSize;
    public FileAppender(String pattern, String fileName, String maxFileSize) {
        super(pattern);
        this.fileName = fileName;
        this.maxFileSize = maxFileSize;
    }

    @Override
    public void sendMessage(String level,String message,String target) {
        //// TODO: 23.02.2016
    }

    public String getMaxFileSize() {
        return maxFileSize;
    }

    public void setMaxFileSize(String maxFileSize) {
        this.maxFileSize = maxFileSize;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
