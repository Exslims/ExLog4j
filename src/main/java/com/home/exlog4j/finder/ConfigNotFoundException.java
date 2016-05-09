package com.home.exlog4j.finder;

/**
 * Exception that throws when configuration file is not found
 */
public class ConfigNotFoundException extends Exception{
    /**
     * Constructs a new ConfigNotFoundException with the specified cause and a detail message
     * @param cause nested exception instance
     */
    public ConfigNotFoundException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new ConfigNotFoundException
     */
    public ConfigNotFoundException() {
        super();
    }
}
