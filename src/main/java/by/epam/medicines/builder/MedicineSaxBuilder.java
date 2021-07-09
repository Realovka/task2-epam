package by.epam.medicines.builder;

import by.epam.medicines.entity.Medicine;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.Set;

public class MedicineSaxBuilder  {
    private static final Logger logger = LogManager.getLogger();
    private Set<Medicine> medicines;
    private MedicineHandler handler = new MedicineHandler();
    private XMLReader reader;

    public MedicineSaxBuilder() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            reader = saxParser.getXMLReader();
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
        reader.setErrorHandler(new MedicineErrorHandler());
        reader.setContentHandler(handler);
    }

    public Set<Medicine> getMedicines() {
        return medicines;
    }

    public void buildSetMedicines(String filepath) {
        try {
            reader.parse(filepath);
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
        medicines = handler.getMedicines();
    }
}
