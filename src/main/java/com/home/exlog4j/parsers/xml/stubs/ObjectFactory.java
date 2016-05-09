package com.home.exlog4j.parsers.xml.stubs;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConfigurationStub }
     * 
     */
    public ConfigurationStub createExlogger() {
        return new ConfigurationStub();
    }

    /**
     * Create an instance of {@link ConfigurationStub.Profile }
     * 
     */
    public ConfigurationStub.Profile createExloggerProfile() {
        return new ConfigurationStub.Profile();
    }

    /**
     * Create an instance of {@link ConfigurationStub.Profile.Appender }
     * 
     */
    public ConfigurationStub.Profile.Appender createExloggerProfileAppender() {
        return new ConfigurationStub.Profile.Appender();
    }

    /**
     * Create an instance of {@link ConfigurationStub.Profile.Appender.File }
     * 
     */
    public ConfigurationStub.Profile.Appender.File createExloggerProfileAppenderFile() {
        return new ConfigurationStub.Profile.Appender.File();
    }

}
