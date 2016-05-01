package com.home.exlog4j.finder;

import com.home.exlog4j.ExLogger;
import com.home.exlog4j.config.ExConfig;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ConfigFinder {

    private static final String CONFIG_FILENAME = "exlog4j-config.xml";

    public static ExConfig find() throws ConfigNotFoundException {
        ClassLoader rootClassLoader = ExLogger.class.getClassLoader();
        String physicalPath = null;
        try {
            physicalPath = rootClassLoader.getResource(CONFIG_FILENAME).getPath();
        } catch (NullPointerException e) {
                /*NOP*/
        }
        if (physicalPath != null) {
            Path transformedPath = Paths.get(physicalPath.substring(1, physicalPath.length()));
            Path absolutePath = transformedPath.toAbsolutePath();
            System.out.println(absolutePath.toString());
            //TODO: return XMLConfigParser.parse(path);
        }
        throw new ConfigNotFoundException();
    }
}
