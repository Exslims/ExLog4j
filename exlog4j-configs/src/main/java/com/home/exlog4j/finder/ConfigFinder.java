package com.home.exlog4j.finder;

import com.home.exlog4j.config.ExConfig;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class ConfigFinder extends SimpleFileVisitor<Path> {

    private ExConfig exConfig;

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println(file.getFileName().toAbsolutePath().toString());
        return FileVisitResult.CONTINUE;
    }
}