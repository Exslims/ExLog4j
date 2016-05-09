package com.home.exlog4j.config.appenders.file.builder;

import com.home.exlog4j.config.appenders.file.FileAppender;

/**
 * Builder class for {@link FileAppender}
 * helps to create FileAppender instances
 */
public class FileAppenderBuilder {

    private String fileName;
    private long maxFileSize;
    private long maxBufferSize;
    private boolean autoFlush;
    private String pattern;

    public  FileAppenderBuilder setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public  FileAppenderBuilder setMaxFileSize(long maxFileSize) {
        this.maxFileSize = maxFileSize;
        return this;
    }

    public  FileAppenderBuilder setMaxBufferSize(long maxBufferSize) {
        this.maxBufferSize = maxBufferSize;
        return this;
    }

    public  FileAppenderBuilder setAutoFlush(boolean autoFlush) {
        this.autoFlush = autoFlush;
        return this;
    }

    public FileAppender build()  {
        return new FileAppender(this.pattern , this.fileName , this.maxFileSize, this.maxBufferSize , this.autoFlush);
    }

    public FileAppenderBuilder setPattern(String pattern) {
        this.pattern = pattern;
        return this;
    }
}