package com.home.exlog4j.parsers.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.home.exlog4j.config.ExConfig;
import com.home.exlog4j.config.appenders.Appender;
import com.home.exlog4j.config.appenders.ConsoleAppender;
import com.home.exlog4j.parsers.JsonConfigParser;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Константин on 25.02.2016.
 */
public class JsonConfigParserTest {
    @Before
    public void before(){
    }
    @Test
    public void testGetConfigs() throws Exception {

    }
    @Test
    public void testWriteIntoJson(){
        ObjectMapper mapper = new ObjectMapper();

        ExConfig config = new ExConfig("INFO");
        List<Appender> appenders = new ArrayList<Appender>();
        appenders.add(new ConsoleAppender("testPattern"));
        appenders.add(new ConsoleAppender("testPattern"));

        config.setAppenderList(appenders);

        try {
            mapper.writeValue(new File("../TestConfig.json"),config);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}