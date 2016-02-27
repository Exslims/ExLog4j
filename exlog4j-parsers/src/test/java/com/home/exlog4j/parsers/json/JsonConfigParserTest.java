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

public class JsonConfigParserTest {
    private static final String ROOT = "/src/test/java/com/home/exlog4j/";
    private static final String JSON_CONFIG_PATH = Paths.get(ROOT + "parsers/json/testConfig1.json").toString();

    @Before
    public void before() throws IOException {
        Files.readAllLines(Paths.get(JSON_CONFIG_PATH)).stream().forEach(System.out::println);
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