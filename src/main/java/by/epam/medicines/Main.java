package by.epam.medicines;

import by.epam.medicines.builder.*;
import by.epam.medicines.exception.MedicineException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger();
    private static final String RELATIVE_FILE_PATH = "E:\\epam\\medicines\\src\\main\\resources\\medicines.xml";
    private static final String RELATIVE_SCHEMA_PATH = "vouchers.xsd";

    public static void main(String[] args) throws MedicineException {

        AbstractMedicineBuilder saxBuilder = MedicineBuilderFactory.createBuilder("sax");
        saxBuilder.buildMedicines(RELATIVE_FILE_PATH);
        System.out.println(saxBuilder.getMedicines());

    }
}

