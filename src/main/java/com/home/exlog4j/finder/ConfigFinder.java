package com.home.exlog4j.finder;

import com.home.exlog4j.ExLogger;
import com.home.exlog4j.config.ExConfig;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ConfigFinder {

    private static final String CONFIG_FILENAME = "exlog4j-config";

    private enum
    AvailableExtension {
        XML,JSON
    }
    public static ExConfig find() throws ConfigNotFoundException {
        ClassLoader rootClassLoader = ExLogger.class.getClassLoader();
        String physicalPath = null;
        for (AvailableExtension extension : AvailableExtension.values()) {
            String fileName = CONFIG_FILENAME + "." + extension.toString().toLowerCase();
            try {
               physicalPath = rootClassLoader.getResource(fileName).getPath();
            }
            catch (NullPointerException e) {
                /*NOP*/
            }
            if (physicalPath != null) {
                Path transformedPath = Paths.get(physicalPath.substring(1, physicalPath.length()));
                Path absolutePath = transformedPath.toAbsolutePath();
                System.out.println(absolutePath.toString());

                switch (extension) {
                    case XML: {
                        //TODO: return XMLConfigParser.parse(path);
                        break;
                    }

                    case JSON: {
                        //TODO: return JSONConfigParser.parse(path);
                        break;
                    }
                }
            }
        }
        throw new ConfigNotFoundException();
    }
}