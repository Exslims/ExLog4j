package com.home.exlog4j;

import com.home.exlog4j.config.appenders.console.ConsoleAppender;
import com.home.exlog4j.config.ExConfig;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConfigsContainerTest {
    @Test
    public void testGetInstance() throws Exception {
        ConfigsContainer container1 = ConfigsContainer.getInstance();
        ConfigsContainer container2 = ConfigsContainer.getInstance();
        assertNotNull(ConfigsContainer.getInstance());
        assertEquals(container1,container2);
    }

    @Test
    public void testGetDefaultConfig() throws Exception {
        ExConfig defaultConfig = ConfigsContainer.getInstance().getConfig("not exist profile");

        assertNotNull(defaultConfig);
        assertNotNull(defaultConfig.getAppenderList());
        assertTrue(defaultConfig.getAppenderList().size() == 1);
        assertEquals(defaultConfig.getLogLevel(),"TRACE");
        assertEquals(defaultConfig.getAppenderList().get(0).getPatternLayout().getPattern(), "%date{yyyy-MM-dd HH:mm:ss} %level %target %- %message");
        assertTrue(defaultConfig.getAppenderList().get(0) instanceof ConsoleAppender);
    }
}