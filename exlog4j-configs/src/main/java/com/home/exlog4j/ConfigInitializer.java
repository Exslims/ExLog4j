package com.home.exlog4j;

import com.home.exlog4j.config.ExConfig;
import com.home.exlog4j.finder.ConfigFinder;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.List;

public class ConfigInitializer {
    private Parser parser;

    public HashMap<String,ExConfig> getConfigs() {
        return new HashMap<>();
    }
}
