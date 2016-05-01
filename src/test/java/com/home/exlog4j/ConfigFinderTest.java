package com.home.exlog4j;

import com.home.exlog4j.finder.ConfigFinder;
import com.home.exlog4j.finder.ConfigNotFoundException;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ConfigFinderTest {
    private static final String CONFIG_FILENAME = "exlog4j-config.xml";

    @Test
    public void findConfigCorrectCase() {
        String path = null;
        try {
            path = ConfigFinder.find(CONFIG_FILENAME);
        } catch (ConfigNotFoundException e) {
            e.printStackTrace();
        }
        assertNotNull(path);
    }


    @Test(expected = ConfigNotFoundException.class)
    public void findConfigIncorrectCase() throws ConfigNotFoundException {
        ConfigFinder.find("test.xml");
    }



    @Test(expected = ConfigNotFoundException.class)
    public void findConfigIncorrectCase1() throws ConfigNotFoundException {
        ConfigFinder.find("exlog4j");
    }



    @Test(expected = ConfigNotFoundException.class)
    public void findConfigIncorrectCase2() throws ConfigNotFoundException {
        ConfigFinder.find("exlog4j-config");
    }



    @Test(expected = ConfigNotFoundException.class)
    public void findConfigIncorrectCase3() throws ConfigNotFoundException {
        ConfigFinder.find("testfile.xml");
    }
}