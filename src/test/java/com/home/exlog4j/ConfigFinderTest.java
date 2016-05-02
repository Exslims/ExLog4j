package com.home.exlog4j;

import com.home.exlog4j.finder.ConfigFinder;
import com.home.exlog4j.finder.ConfigNotFoundException;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ConfigFinderTest {

    @Test
    public void findConfigCorrectCase() {
        String path = null;
        try {
            path = ConfigFinder.find();
        } catch (ConfigNotFoundException e) {
            e.printStackTrace();
        }
        assertNotNull(path);
    }
}