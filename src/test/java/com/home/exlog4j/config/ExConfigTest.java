package com.home.exlog4j.config;

import com.home.exlog4j.config.appenders.Appender;
import com.home.exlog4j.config.appenders.console.ConsoleAppender;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ExConfigTest {
    private ExConfig config;
    @Before
    public void before(){
       config = new ExConfig("DEBUG");
    }
    @Test
    public void testGetLogLevel() throws Exception {
        assertEquals(config.getLogLevel(),"DEBUG");
    }

    @Test
    public void testSetLogLevel() throws Exception {
        config.setLogLevel("INFO");
        assertEquals(config.getLogLevel(),"INFO");
    }

    @Test
    public void testGetAppenderList() throws Exception {
        assertNotNull(config.getAppenderList());
        assertEquals(config.getAppenderList().size(),0);
    }

    @Test
    public void testSetAppenderList() throws Exception {
        List<Appender> appenders = new ArrayList<Appender>();
        appenders.add(new ConsoleAppender("testPattern"));
        appenders.add(new ConsoleAppender("testPattern"));

        config.setAppenderList(appenders);
        assertEquals(config.getAppenderList().size(),2);
    }

    @Test
    public void testAddAppender() throws Exception {
        config.addAppender(new ConsoleAppender("testPattern"));
        assertNotNull(config.getAppenderList());
        assertEquals(config.getAppenderList().size(),1);
    }
}