package com.home.exlog4j;

/**
 * Base logger interface, has {@link ExLogger} implementation
 */
public interface Logger {
    void trace(Object message);
    void debug(Object message);
    void info(Object message);
    void warn(Object message);
    void error(Object message);
    void error(Object object, Throwable throwable);
    void fatal(Object message);
    void fatal(Object object, Throwable throwable);
    Level getLevel();
    void setLevel(Level level);
    String getProfileName();
    void setProfileName(String profileName);
}
