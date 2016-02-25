package com.home.exlog4j.config.appenders;

import com.home.exlog4j.config.appenders.Appender;

public class FileAppender extends Appender {
    private String fileName;
    private long maxFileSize;
    private long maxBufferSize;
    private boolean autoFlush;
    private int currentFileIndex;
    private long currentFileSize;
    private long currentBytesCount;

    public FileAppender(String pattern) {
        super(pattern);
    }

    public FileAppender(String pattern, String fileName, long maxFileSize) {
        super(pattern);
        this.autoFlush = true;
        this.fileName = fileName;
        this.maxFileSize = maxFileSize;
    }

    @Override
    public void sendMessage(String level,String message,String target) {
        //// TODO: 23.02.2016
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public long getMaxFileSize() {
        return maxFileSize;
    }

    public void setMaxFileSize(long maxFileSize) {
        this.maxFileSize = maxFileSize;
    }

    public long getMaxBufferSize() {
        return maxBufferSize;
    }

    public void setMaxBufferSize(long maxBufferSize) {
        this.maxBufferSize = maxBufferSize;
    }

    public boolean isAutoFlush() {
        return autoFlush;
    }

    public void setAutoFlush(boolean autoFlush) {
        this.autoFlush = autoFlush;
    }
}
