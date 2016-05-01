package com.home.exlog4j.finder;

import com.home.exlog4j.ExLogger;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ConfigFinder {

    public static String find(String configFileName) throws ConfigNotFoundException {
        ClassLoader rootClassLoader = ExLogger.class.getClassLoader();
        String physicalPath = null;
        try {
            physicalPath = rootClassLoader.getResource(configFileName).getPath();
        } catch (NullPointerException e) {
                /*NOP*/
        }
        if (physicalPath != null) {
            Path transformedPath = Paths.get(physicalPath.substring(1, physicalPath.length()));
            Path absolutePath = transformedPath.toAbsolutePath();
            return absolutePath.toString();
        }
        throw new ConfigNotFoundException();
    }
}
