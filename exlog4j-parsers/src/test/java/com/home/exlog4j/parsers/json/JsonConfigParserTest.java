package com.home.exlog4j.parsers.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.home.exlog4j.config.ExConfig;
import com.home.exlog4j.config.appenders.Appender;
import com.home.exlog4j.config.appenders.console.ConsoleAppender;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Константин on 25.02.2016.
 */
public class JsonConfigParserTest {




    @Before
    public void before(){

            List<String>  strings = null;
            try {
                strings = Files.readAllLines(Paths.get("src" , "test" , "java" , "com" , "home" , "exlog4j" , "parsers" , "json" , "testConfig1.json"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            for (String line : strings)
                System.out.println(line);

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