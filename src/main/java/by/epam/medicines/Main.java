package by.epam.medicines;

import by.epam.medicines.builder.*;
import by.epam.medicines.exception.MedicineException;
import by.epam.medicines.validator.MedicineXmlValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger();
    private static final String RELATIVE_FILE_PATH = "E:\\epam\\medicines\\src\\main\\resources\\data\\medicines.xml";
    private static final String RELATIVE_SCHEMA_PATH = "vouchers.xsd";

    public static void main(String[] args) throws MedicineException {

//        MedicineXmlValidator validator = new MedicineXmlValidator();
//        if (!validator.isValidXmlFile(RELATIVE_FILE_PATH, RELATIVE_SCHEMA_PATH)) {
//            return;
//        }

        AbstractMedicineBuilder saxBuilder = MedicineBuilderFactory.createBuilder("sax");
        saxBuilder.buildMedicines(RELATIVE_FILE_PATH);
        System.out.println(saxBuilder.getMedicines());

    }
}

