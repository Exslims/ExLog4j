package com.home.exlog4j.parsers;

/**
 * Parser Initializer for {@link ParsersFactory}
 * Initializes parser
 * @param <T> Generic parser class
 */
public interface ParserInitializer<T extends Parser> {
    /**
     * Initializes new parser
     * @return parser
     */
    T newInstance();
}
