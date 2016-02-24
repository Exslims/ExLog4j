package com.home.exlog4j.config.appenders;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;


public class ConsoleAppenderTest {

    public static final String LAYOUT = "%level %target %- %message";
    private final OutputStream stdOut = new ByteArrayOutputStream();
    private final OutputStream stdErr = new ByteArrayOutputStream();
    public static final ConsoleAppender CONSOLE_APPENDER = new ConsoleAppender(LAYOUT);

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(stdOut));
        System.setErr(new PrintStream(stdErr));
    }


    @Test
    public void testSendTraceMessage() throws Exception {
        String traceLevel = "TRACE";
        String target = this.toString();
        String message = "Trace message";
        CONSOLE_APPENDER.sendMessage(traceLevel, message, target);
        String line = traceLevel + " " +  target + " - " + message;
        assertTrue(stdOut.toString().contains(line));
    }



    @Test
    public void testSendErrorMessage() throws Exception {
        String errorLevel = "ERROR";
        String target = this.toString();
        String message = "Error message";
        CONSOLE_APPENDER.sendMessage(errorLevel, message, target);
        String line = errorLevel + " " +  target + " - " + message;
        assertTrue(stdErr.toString().contains(line));
    }


    @Test
    public void testSendFatalMessage() throws Exception {
        String fatalLevel = "FATAL";
        String target = this.toString();
        String message = "Fatal message";
        CONSOLE_APPENDER.sendMessage(fatalLevel, message, target);
        String line = fatalLevel + " " +  target + " - " + message;
        assertTrue(stdErr.toString().contains(line));
    }


    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }
}