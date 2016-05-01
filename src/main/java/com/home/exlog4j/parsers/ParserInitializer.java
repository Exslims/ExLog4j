package com.home.exlog4j.parsers;

/**
 * Created by Константин on 01.05.2016.
 */
public interface ParserInitializer<T extends Parser> {
    T newInstance();
}
