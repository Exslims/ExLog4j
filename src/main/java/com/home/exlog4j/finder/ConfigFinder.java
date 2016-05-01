package com.home.exlog4j.finder;

import com.home.exlog4j.config.ExConfig;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;

public class ConfigFinder {

    public static final String ROOT = System.getProperty("user.dir");

    public static ExConfig find() throws ConfigNotFoundException {
        ExConfig exConfig;
        FileVisitor fileVisitor = new FileVisitor();
        try {
            Files.walkFileTree(Paths.get(ROOT) , fileVisitor);
            exConfig = fileVisitor.getResult();
        } catch (IOException e) {
            throw new ConfigNotFoundException(e);
        }

        if (Objects.isNull(exConfig))
            throw new ConfigNotFoundException();
        return exConfig;
    }

    private static class FileVisitor  extends SimpleFileVisitor<Path> {
        private ExConfig result;

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) throws IOException {
            System.out.println(file.getFileName().toAbsolutePath().toString());
            //TODO: добавить реализацию метода
            return FileVisitResult.CONTINUE;
        }

        public ExConfig getResult() {
            return result;
        }
    }
}