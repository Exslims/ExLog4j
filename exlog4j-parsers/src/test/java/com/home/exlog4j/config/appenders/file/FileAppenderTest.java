package com.home.exlog4j.config.appenders.file;

import com.home.exlog4j.config.appenders.file.FileAppender;
import com.home.exlog4j.config.appenders.file.FileAppenderBuilder;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class FileAppenderTest {
    public static final String LAYOUT = "%level %target %- %message";
    public static final String FILE_NAME = "test.log";
    public static final String EMPTY_STRING = "";
    public static final int MAX_FILE_SIZE = 1024;
    public static final int MAX_BUFFER_SIZE = 8;
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
                .setMaxFileSize(MAX_FILE_SIZE)
                .setMaxBufferSize(MAX_BUFFER_SIZE)
                .build();
    }

    @Test
    public void testSendMessage() throws Exception {
        this.fileAppender.setAutoFlush(true);
        this.fileAppender.sendMessage("TRACE" , "HELLO MESSAGE" , this.toString());
        List<String> lines = Files.readAllLines(Paths.get(fileAppender.getFileName()));
        assertTrue(lines.size() > 0);
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
        assertTrue(fileAppender.getMaxFileSize() == MAX_FILE_SIZE);
    }

    @Test
    public void testSetMaxFileSize() throws Exception {
        int maxFileSize = 2 * 1024;
        fileAppender.setMaxFileSize(maxFileSize);
        assertTrue(fileAppender.getMaxFileSize() == maxFileSize);
    }

    @Test
    public void testGetMaxBufferSize() throws Exception {
        assertTrue(fileAppender.getMaxBufferSize() == MAX_BUFFER_SIZE);
    }

    @Test
    public void testSetMaxBufferSize() throws Exception {
        int maxBufferSize = 2 * 1024;
        fileAppender.setMaxBufferSize(maxBufferSize);
        assertTrue(fileAppender.getMaxBufferSize() == maxBufferSize);
    }

    @Test
    public void testIsAutoFlush() throws Exception {
        assertTrue(fileAppender.isAutoFlush());
    }

    @Test
    public void testSetAutoFlush() throws Exception {
        fileAppender.setAutoFlush(false);
        assertFalse(fileAppender.isAutoFlush());
        fileAppender.setAutoFlush(true);
        assertTrue(fileAppender.isAutoFlush());
    }
}