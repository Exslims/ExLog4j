package com.home.exlog4j.finder;

import com.home.exlog4j.ExLogger;
import com.home.exlog4j.parsers.ParsersType;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Finds configuration in external classpath using {@link ExLogger} classloader
 */
public class ConfigFinder {

    private static final String CONFIG_FILENAME = "exlog4j-config";

    /**
     * Enumeration that represent available extension for configuration file
     */
    private enum AvailableExtension {
        XML,
        JSON
    }

    /**
     * Gets information about found configuration
     * @return new instance of  {@link ConfigInfo}
     * @throws ConfigNotFoundException when configuration file is not found
     */
    public ConfigInfo findConfiguration() throws ConfigNotFoundException {
        ClassLoader rootClassLoader = ExLogger.class.getClassLoader();
        String physicalPath = null;
        for (AvailableExtension extension : AvailableExtension.values()) {
            String fileName = CONFIG_FILENAME + "." + extension.toString().toLowerCase();
            try {
                physicalPath = rootClassLoader.getResource(fileName).getPath();
            } catch (NullPointerException e) {
                /*NOP*/
            }
            if (physicalPath != null) {
                Path transformedPath = Paths.get(physicalPath.substring(1, physicalPath.length()));
                Path absolutePath = transformedPath.toAbsolutePath();
                return new ConfigInfo(absolutePath.toString() , ParsersType.valueOf(extension.toString()));
            }
        }
        throw new ConfigNotFoundException();
    }
}
