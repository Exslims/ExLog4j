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

    /**
     * Sets FileAppenderBuilder property
     * @param fileName {@link FileAppender} filename property
     *  allowed object is {@link String}
     * @return {@link FileAppenderBuilder} instance
     */
    public  FileAppenderBuilder setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    /**
     * Sets FileAppenderBuilder property
     * @param maxFileSize {@link FileAppender} maxFileSize property
     *  allowed object is {@link Long}
     * @return {@link FileAppenderBuilder} instance
     */
    public  FileAppenderBuilder setMaxFileSize(long maxFileSize) {
        this.maxFileSize = maxFileSize;
        return this;
    }

    /**
     * Sets FileAppenderBuilder property
     * @param maxBufferSize {@link FileAppender} maxBufferSize property
     *  allowed object is {@link Long}
     * @return {@link FileAppenderBuilder} instance
     */
    public  FileAppenderBuilder setMaxBufferSize(long maxBufferSize) {
        this.maxBufferSize = maxBufferSize;
        return this;
    }


    /**
     * Sets FileAppenderBuilder property
     * @param autoFlush {@link FileAppender} maxBufferSize property
     *  allowed object is {@link Boolean}
     * @return {@link FileAppenderBuilder} instance
     */
    public  FileAppenderBuilder setAutoFlush(boolean autoFlush) {
        this.autoFlush = autoFlush;
        return this;
    }

    /**
     * Creates new FileAppender instance
     * @return instance of constructed FileAppender
     */
    public FileAppender build()  {
        return new FileAppender(this.pattern , this.fileName , this.maxFileSize, this.maxBufferSize , this.autoFlush);
    }

    /**
     * Sets pattern for parent {@link com.home.exlog4j.config.appenders.PatternLayout} field
     * @param pattern ExLog4j pattern
     * @return {@link FileAppenderBuilder} instance
     */
    public FileAppenderBuilder setPattern(String pattern) {
        this.pattern = pattern;
        return this;
    }
}