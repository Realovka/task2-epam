package by.epam.medicines.builder;

import by.epam.medicines.entity.Medicine;
import by.epam.medicines.exception.MedicineException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.Set;

public class MedicineSaxBuilder extends AbstractMedicineBuilder {
    private static final Logger logger = LogManager.getLogger();
    private Set<Medicine> medicines;
    private MedicineHandler handler = new MedicineHandler();
    private XMLReader reader;

    public MedicineSaxBuilder() throws MedicineException{
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            reader = saxParser.getXMLReader();
        } catch (ParserConfigurationException e) {
            logger.error("Configuration failed " + e);
            throw new MedicineException("Configuration failed " + e);
        } catch (SAXException e) {
            logger.error("Error when file parse " + e);
            throw new MedicineException("Error when file parse " + e);
        }
        reader.setErrorHandler(new MedicineErrorHandler());
        reader.setContentHandler(handler);
    }

    public Set<Medicine> getMedicines() {
        return medicines;
    }

    public void buildMedicines(String filepath) throws MedicineException {
        try {
            reader.parse(filepath);
        } catch (IOException e) {
            logger.error("Error when file read " + e);
            throw new MedicineException("Error when file read " + e);
        } catch (SAXException e) {
            logger.error("Error when file parse " + e);
            throw new MedicineException("Error when file parse " + e);
        }
        medicines = handler.getMedicines();
    }
}
