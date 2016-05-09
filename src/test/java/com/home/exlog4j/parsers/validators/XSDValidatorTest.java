package com.home.exlog4j.parsers.validators;

import org.junit.Ignore;
import org.junit.Test;
import org.xml.sax.SAXParseException;

import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

public class XSDValidatorTest {
    private static final String ROOT = Paths.get("src" , "test/java/com/home/exlog4j/").toAbsolutePath().toString();
    private String XML_CONFIG_PATH = Paths.get(ROOT + "/parsers/xml/").toAbsolutePath().toString();
    private static final String XSD_PATH = Paths.get(ROOT + "/parsers/validators/exlogger.xsd").toAbsolutePath().toString();

    @Test(expected = SAXParseException.class)
    public void testValidateWrongCase1() throws Exception {
        XSDValidator.validateXMLSchema(XML_CONFIG_PATH + "/wrongCase1.xml",XSD_PATH);
    }
    @Test(expected = SAXParseException.class)
    public void testValidateWrongCase2() throws Exception {
        XSDValidator.validateXMLSchema(XML_CONFIG_PATH + "/wrongCase2.xml",XSD_PATH);
    }
    @Test(expected = SAXParseException.class)
    public void testValidateWrongCase3() throws Exception {
        XSDValidator.validateXMLSchema(XML_CONFIG_PATH + "/wrongCase3.xml",XSD_PATH);
    }
    @Test(expected = SAXParseException.class)
    public void testValidateWrongCase4() throws Exception {
        XSDValidator.validateXMLSchema(XML_CONFIG_PATH + "/wrongCase4.xml",XSD_PATH);
    }
    @Test(expected = SAXParseException.class)
    public void testValidateWrongCase5() throws Exception {
        XSDValidator.validateXMLSchema(XML_CONFIG_PATH + "/wrongCase5.xml",XSD_PATH);
    }
    @Test
    public void testValidateCorrectlyCase1() throws Exception {
        assertTrue(XSDValidator.validateXMLSchema(XML_CONFIG_PATH + "/corrCase1.xml",XSD_PATH));
    }
    @Test
    public void testValidateCorrectlyCase2() throws Exception {
        assertTrue(XSDValidator.validateXMLSchema(XML_CONFIG_PATH + "/corrCase2.xml",XSD_PATH));
    }

    @Ignore
    @Test
    public void testValidateCorrectlyCase3() throws Exception {
        assertTrue(XSDValidator.validateXMLSchema(XML_CONFIG_PATH + "/corrCase3.xml",XSD_PATH));
    }
    @Test
    public void testValidateCorrectlyCase4() throws Exception {
        assertTrue(XSDValidator.validateXMLSchema(XML_CONFIG_PATH + "/corrCase4.xml",XSD_PATH));
    }
    @Test
    public void testValidateCorrectlyCase5() throws Exception {
        assertTrue(XSDValidator.validateXMLSchema(XML_CONFIG_PATH + "/corrCase5.xml",XSD_PATH));
    }
    @Test
    public void testValidateCorrectlyCase6() throws Exception {
        assertTrue(XSDValidator.validateXMLSchema(XML_CONFIG_PATH + "/corrCase6.xml",XSD_PATH));
    }

    @Ignore
    @Test
    public void testValidateCorrectlyCase7() throws Exception {
        assertTrue(XSDValidator.validateXMLSchema(XML_CONFIG_PATH + "/corrCase7.xml",XSD_PATH));
    }

    @Ignore
    @Test
    public void testValidateCorrectlyCase8() throws Exception {
        assertTrue(XSDValidator.validateXMLSchema(XML_CONFIG_PATH + "/corrCase8.xml",XSD_PATH));
    }
}