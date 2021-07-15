package by.epam.medicines.validator;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

public class MedicineXmlValidatorTest {

    private static final String RELATIVE_FILE_PATH_TO_VALID_XML = "data/medicine_is_valid.xml";
    private static final String RELATIVE_FILE_PATH_TO_INVALID_XML = "data/medicine_is_invalid.xml";
    private static final String RELATIVE_SCHEMA_PATH = "data/medicines.xsd";
    MedicineXmlValidator validator;
    String pathToValidXml;
    String pathToInvalidXml;
    String pathToXsd;

    @BeforeMethod
    public void setUp() {
        validator = new MedicineXmlValidator();
        pathToValidXml = ClassLoader.getSystemClassLoader().getResource(RELATIVE_FILE_PATH_TO_VALID_XML).getFile();
        pathToInvalidXml = ClassLoader.getSystemClassLoader().getResource(RELATIVE_FILE_PATH_TO_INVALID_XML).getFile();
        pathToXsd = ClassLoader.getSystemClassLoader().getResource(RELATIVE_SCHEMA_PATH).getFile();
    }

    @Test
    public void testIsValidXmlFile() {
        boolean result = validator.isValidXmlFile(pathToValidXml, pathToXsd);
        assertTrue(result);
    }

    @Test
    public void testIsInvalidXmlFile() {
        boolean result = validator.isValidXmlFile(pathToInvalidXml, pathToXsd);
        assertFalse(result);
    }
}