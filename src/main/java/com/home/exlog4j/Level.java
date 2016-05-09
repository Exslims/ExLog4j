package com.home.exlog4j;

/**
 * Enumeration that represent logging level for {@link ExLogger}
 */
public enum Level implements Comparable<Level> {
    OFF,
    FATAL,
    ERROR,
    WARN,
    INFO,
    DEBUG,
    TRACE,ALL
}