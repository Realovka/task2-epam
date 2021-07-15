package by.epam.medicines;

import by.epam.medicines.builder.AbstractMedicineBuilder;
import by.epam.medicines.builder.MedicineBuilderFactory;
import by.epam.medicines.exception.MedicineException;
import by.epam.medicines.validator.MedicineXmlValidator;

public class Main{

    private static final String RELATIVE_FILE_PATH = "data/medicines.xml";
    private static final String RELATIVE_SCHEMA_PATH = "data/medicines.xsd";

    public static void main(String[] args) throws MedicineException {
        MedicineXmlValidator validator = new MedicineXmlValidator();
        String pathToXml = ClassLoader.getSystemClassLoader().getResource(RELATIVE_FILE_PATH).getFile();
        String pathToXsd = ClassLoader.getSystemClassLoader().getResource(RELATIVE_SCHEMA_PATH).getFile();

        if (!validator.isValidXmlFile(pathToXml, pathToXsd)) {
            return;
        }

        AbstractMedicineBuilder saxBuilder = MedicineBuilderFactory.createBuilder("sax");
        saxBuilder.buildMedicines(pathToXml);
        System.out.println(saxBuilder.getMedicines());

        AbstractMedicineBuilder staxBuilder = MedicineBuilderFactory.createBuilder("stax");
        staxBuilder.buildMedicines(pathToXml);
        System.out.println(staxBuilder.getMedicines());

        AbstractMedicineBuilder domBuilder = MedicineBuilderFactory.createBuilder("dom");
        domBuilder.buildMedicines(pathToXml);
        System.out.println(domBuilder.getMedicines());

    }


}

