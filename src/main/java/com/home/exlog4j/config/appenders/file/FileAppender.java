package com.home.exlog4j.config.appenders.file;

import com.home.exlog4j.config.appenders.Appender;
import com.home.exlog4j.config.appenders.PatternLayout;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Implementation for {@link Appender} interface, that represents
 * buffered appender that serves to write logs into the file
 */
public class FileAppender extends Appender {
    public static final int KB = 1024;
    public static final int MB = 1024 * KB;
    private PrintWriter writer;
    private String fileName;
    private long maxFileSize;
    private long maxBufferSize;
    private boolean autoFlush;
    private int currentFileIndex;
    private long currentFileSize;


    /**
     * Constructs new FileAppender instance
     * @param pattern logging pattern for {@link PatternLayout}
     */
    public FileAppender(String pattern) {
        super(pattern);
        this.autoFlush = false;
        this.currentFileSize = 0;
        this.maxBufferSize = 2 * KB;
        this.currentFileIndex = 1;
        this.maxFileSize = 2 * MB;
        this.registerShutdownHook();
    }


    /**
     * Registering JVM native hook for buffer flushing when
     * buffer is completely filled with data
     */
    private void registerShutdownHook() {
        Runtime runtime = Runtime.getRuntime();
        runtime.addShutdownHook(new Thread(
                () -> {
                    writer.flush();
                }
        ));
    }

    /**
     * Constructs new FileAppender instance
     * @param pattern logging pattern for {@link PatternLayout}
     * @param fileName name of target file
     * @param maxFileSize the maximum possible value of target file size
     * @param maxBufferSize the maximum possible value of current buffer
     * @param autoFlush automatic buffer flushing
     */
    public FileAppender(String pattern,
                 String fileName,
                 long maxFileSize,
                 long maxBufferSize,
                 boolean autoFlush) {
        this(pattern);

        if (fileName.equals(""))
            throw new IllegalArgumentException("Invalid file name : " + fileName);

        this.fileName = fileName;

        if (maxFileSize == 0)
            throw new IllegalArgumentException("Invalid max file size : " + maxFileSize);

        this.maxFileSize = maxFileSize;
        this.maxBufferSize = maxBufferSize;
        this.autoFlush = autoFlush;
        try {
            File logFile = new File(fileName);
            FileOutputStream fileOutputStream = new FileOutputStream(logFile, autoFlush);
            this.writer =  new PrintWriter(fileOutputStream);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }


    @Override
    public void sendMessage(String level,String message,String target) {
        long currentBufferSize = 0;
        String line = this.patternLayout.getFormattedMessage(level , message , target);
        writer.println(line);
        currentBufferSize += line.getBytes().length;
//        System.out.println("CBS" + currentBufferSize);
//        System.out.println("MBS" + maxBufferSize);
        currentFileSize += currentBufferSize;
        if (currentBufferSize > maxBufferSize) {
            this.writer.flush();
            currentBufferSize = 0;
        }

        if (currentFileSize >= maxFileSize) {
            try {
                File logFile = new File(fileName + " - " + currentFileIndex);
                FileOutputStream fileOutputStream = new FileOutputStream(logFile, autoFlush);
                this.writer = new PrintWriter(fileOutputStream);
                currentFileIndex++;
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }

    /**
     * Gets the value of the maxFileSize property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFileName() {
        return this.fileName;
    }


    /**
     * Sets the value of the fileName property.
     *
     * @param fileName
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFileName(String fileName) {
        try {
            File logFile = new File(fileName);
            FileOutputStream fileOutputStream = new FileOutputStream(logFile, autoFlush);
            this.writer =  new PrintWriter(fileOutputStream);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        this.fileName = fileName;
    }

    /**
     * Sets the value of the maxFileSize property.
     *
     * @return
     *     possible object is
     *     {@link Long }
     *
     */
    public long getMaxFileSize() {
        return maxFileSize;
    }

    /**
     * Sets the value of the autoFlush property.
     *
     * @param maxFileSize
     *     allowed object is
     *     {@link Long }
     *
     */
    public void setMaxFileSize(long maxFileSize) {
        this.maxFileSize = maxFileSize;
    }

    /**
     * Gets the value of the maxBufferSize property.
     *
     * @return
     *     possible object is
     *     {@link Long }
     *
     */
    public long getMaxBufferSize() {
        return maxBufferSize;
    }

    /**
     * Sets the value of the maxBufferSize property.
     *
     * @param maxBufferSize
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setMaxBufferSize(long maxBufferSize) {
        this.maxBufferSize = maxBufferSize;
    }

    /**
     * Gets the value of the autoFlush property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public boolean isAutoFlush() {
        return autoFlush;
    }

    /**
     * Sets the value of the autoFlush property.
     *
     * @param autoFlush
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setAutoFlush(boolean autoFlush) {
        this.autoFlush = autoFlush;
    }
}
