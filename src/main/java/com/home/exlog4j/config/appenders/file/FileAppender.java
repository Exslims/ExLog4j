package com.home.exlog4j.config.appenders.file;

import com.home.exlog4j.config.appenders.Appender;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

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

    public FileAppender(String pattern) {
        super(pattern);
        this.autoFlush = false;
        this.currentFileSize = 0;
        this.maxBufferSize = 2 * KB;
        this.currentFileIndex = 1;
        this.maxFileSize = 2 * MB;
    }

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
        System.out.println("CBS" + currentBufferSize);
        System.out.println("MBS" + maxBufferSize);

        currentFileSize += currentBufferSize;
        if (currentBufferSize > maxBufferSize) {
            this.writer.flush();
            currentBufferSize = 0;
        }


        System.out.println(currentFileSize);
        System.out.println(currentBufferSize);
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

    public String getFileName() {
        return this.fileName;
    }

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
