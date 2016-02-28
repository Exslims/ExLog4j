package com.home.exlog4j;

import com.home.exlog4j.finder.ConfigFinder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;


public class ConfigFinderTest {

    @Test
    public void findConfig() {
        System.out.println(System.getProperty("user.dir"));
        ConfigFinder finder = new ConfigFinder();
        try {
            Files.walkFileTree(Paths.get(System.getProperty("user.dir")) , finder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}