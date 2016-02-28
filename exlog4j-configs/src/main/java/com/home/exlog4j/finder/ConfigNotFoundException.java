package com.home.exlog4j.finder;

public class ConfigNotFoundException extends Exception{
    public ConfigNotFoundException(Throwable cause) {
        super(cause);
    }

    public ConfigNotFoundException() {
        super();
    }
}
