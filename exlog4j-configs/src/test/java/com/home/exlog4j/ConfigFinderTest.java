package com.home.exlog4j;

import com.home.exlog4j.config.ExConfig;
import com.home.exlog4j.finder.ConfigFinder;
import com.home.exlog4j.finder.ConfigNotFoundException;
import org.junit.Test;

import static org.junit.Assert.*;


public class ConfigFinderTest {


    @Test
    public void findConfig() {
        ExConfig exConfig = null;
        try {
            exConfig = ConfigFinder.find();
        } catch (ConfigNotFoundException e) {
            e.printStackTrace();
        }
        assertNotNull(exConfig);
    }

}