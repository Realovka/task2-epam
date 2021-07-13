package by.epam.medicines.builder;

import by.epam.medicines.exception.MedicineException;

public class MedicineBuilderFactory {
    private enum TypeParser {
        SAX, STAX, DOM
    }


    public static AbstractMedicineBuilder createBuilder(String typeParser) throws MedicineException {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type) {
            case DOM : {
                return new MedicineDomBuilder();
            }
            case STAX : {
                return new MedicineStaxBuilder();
            }
            case SAX : {
                return new MedicineSaxBuilder();
            }
            default : {
                throw new MedicineException("No such constant " + typeParser);
            }
        }
    }
}
