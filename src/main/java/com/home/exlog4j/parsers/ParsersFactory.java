package com.home.exlog4j.parsers;

import java.util.HashMap;

public class ParsersFactory {
    private static HashMap<ParsersType, ParserInitializer> parsers;

    static{
        parsers = new HashMap<>();

        register(ParsersType.XML, () -> new XmlConfigParser());
        register(ParsersType.JSON, () -> new JsonConfigParser());
        register(ParsersType.PROPERTIES, () -> new PropertiesConfigParser());
    }
    /**
     * Getting parser by file extension
     * @param key file extension
     * @return parser
     */
    public static Parser getParser(ParsersType key){
        return parsers.get(key).newInstance();
    }

    /**
     * Add parser to map
     * @param key file extension
     * @param parser parser
     */
    public static void register(ParsersType key, ParserInitializer parser){
        parsers.put(key,parser);
    }
}
