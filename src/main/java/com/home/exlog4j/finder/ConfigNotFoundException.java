package com.home.exlog4j.finder;

/**
 * Exception that throws when configuration file is not found
 */
public class ConfigNotFoundException extends Exception{
    public ConfigNotFoundException(Throwable cause) {
        super(cause);
    }

    public ConfigNotFoundException() {
        super();
    }
}
