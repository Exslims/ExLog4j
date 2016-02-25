package com.home.exlog4j.config.appenders;


import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Константин on 24.02.2016.
 */
public class PatternLayoutTest {
    private PatternLayout patternLayout = new PatternLayout();
    private Date date = new Date(System.currentTimeMillis());
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Before public void before(){
        patternLayout.setDate(date);
    }
    @Test
    public void testGetFormattedMessage() throws Exception {
        patternLayout.setPattern("%level %target %- %message");
        assertEquals(patternLayout.getFormattedMessage("TRACE","Test log",PatternLayoutTest.class.getSimpleName()),
                "TRACE PatternLayoutTest - Test log ");

        patternLayout.setPattern("%date{yyyy-MM-dd HH:mm:ss} %level %target %- %message");
        assertEquals(patternLayout.getFormattedMessage("TRACE","Test log",PatternLayoutTest.class.getSimpleName()),
                dateFormat.format(date) + "  TRACE PatternLayoutTest - Test log ");
    }

    @Test
    public void testGetPattern() throws Exception {
        patternLayout.setPattern("%date{yyyy-MM-dd HH:mm:ss} %level %target %- %message");
        assertEquals(patternLayout.getPattern(),"%date{yyyy-MM-dd HH:mm:ss} %level %target %- %message");
    }

    @Test
    public void testPriority() throws Exception{
        patternLayout.setPattern("%level %target %- %message %date{yyyy-MM-dd HH:mm:ss}");
        assertEquals(patternLayout.getFormattedMessage("TRACE","Test log",PatternLayoutTest.class.getSimpleName()),
                "TRACE PatternLayoutTest - Test log " + dateFormat.format(date) + " ");

        patternLayout.setPattern("%level %target %- %message %level %date{yyyy-MM-dd HH:mm:ss}");
        assertEquals(patternLayout.getFormattedMessage("TRACE","Test log",PatternLayoutTest.class.getSimpleName()),
                "TRACE PatternLayoutTest - Test log TRACE " + dateFormat.format(date) + " ");

        patternLayout.setPattern("  %- %level %message %level %date{yyyy-MM-dd HH:mm:ss}  %target");
        assertEquals(patternLayout.getFormattedMessage("TRACE","Test log",PatternLayoutTest.class.getSimpleName()),
                "- TRACE Test log TRACE " + dateFormat.format(date) + " PatternLayoutTest ");

    }
    @Test
    public void testIncorrectPatterns(){
        patternLayout.setPattern("%level %%%% %target      + %level         %target");
        assertEquals(patternLayout.getFormattedMessage("TRACE","Test log",PatternLayoutTest.class.getSimpleName()),
                "TRACE PatternLayoutTest TRACE PatternLayoutTest ");

        patternLayout.setPattern("^%%%%%%%%%");
        assertEquals(patternLayout.getFormattedMessage("TRACE","Test log",PatternLayoutTest.class.getSimpleName()),
                "^ ");
        patternLayout.setPattern("%%%%%%%%% ");
        assertEquals(patternLayout.getFormattedMessage("TRACE","Test log",PatternLayoutTest.class.getSimpleName()),
                "");

    }
}