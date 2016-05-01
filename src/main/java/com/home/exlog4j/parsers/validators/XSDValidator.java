package com.home.exlog4j.parsers.validators;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class XSDValidator {
    private static final String ROOT = Paths.get("src" , "test/java/com/home/exlog4j/").toAbsolutePath().toString();
    private static final String XSD_PATH = Paths.get(ROOT + "/xsd/exlogger.xsd").toAbsolutePath().toString();

    public static boolean validateXMLSchema(String xmlPath, String xsdPath) throws SAXException, IOException {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = factory.newSchema(new File(xsdPath));

        Validator validator = schema.newValidator();
        validator.validate(new StreamSource(new File(xmlPath)));
        return true;

    }
}
