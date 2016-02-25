package com.home.exlog4j.config.appenders.file;

import com.home.exlog4j.config.appenders.file.FileAppender;
import com.home.exlog4j.config.appenders.file.FileAppenderBuilder;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertTrue;


public class FileAppenderTest {
    public static final String LAYOUT = "%level %target %- %message";
    public static final String FILE_NAME = "test.log";
    public static final String EMPTY_STRING = "";
    private FileAppender fileAppender;

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Before
    public void initFileAppender() {
        File log = new File(FILE_NAME);
        try {
            log = temporaryFolder.newFile(FILE_NAME);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        this.fileAppender = new FileAppenderBuilder()
                .setFileName(log.getAbsolutePath())
                .setAutoFlush(true)
                .setPattern(LAYOUT)
                .setMaxFileSize(1024)
                .setMaxBufferSize(8)
                .build();
    }

    @Test
    public void testSendMessage() throws Exception {
        this.fileAppender.sendMessage("TRACE" , "HELLO MESSAGE" , this.toString());
    }

    @Test
    public void testGetFileName() throws Exception {
        assertTrue(!fileAppender.getFileName().equals(EMPTY_STRING));
    }

    @Test
    public void testSetFileName() throws Exception {
        String fileName = "new file name.log";
        fileAppender.setFileName(fileName);
        assertTrue(fileAppender.getFileName().equals(fileName));
    }

    @Test
    public void testGetMaxFileSize() throws Exception {

    }

    @Test
    public void testSetMaxFileSize() throws Exception {

    }

    @Test
    public void testGetMaxBufferSize() throws Exception {

    }

    @Test
    public void testSetMaxBufferSize() throws Exception {

    }

    @Test
    public void testIsAutoFlush() throws Exception {

    }

    @Test
    public void testSetAutoFlush() throws Exception {

    }
}