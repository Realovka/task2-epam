package by.epam.medicines.builder;

public enum MedicineXmlTag {
    MEDICINE,
    NAME,
    PHARM,
    GROUP,
    ANALOG,
    ANALOG_NAME,
    VERSION,
    FORM,
    CERTIFICATE,
    NUMBER,
    ISSUANCE,
    EXPIRATION,
    PACKAGE,
    TYPE,
    NUMBER_IN_PACKAGE,
    PRICE_PER_PACKAGE,
    DOSAGE,
    DRUG_DOSAGE,
    RECEPTION_MULTIPLICITY;

    private static final char REPLACE_CHAR = '_';
    private static final char NEW_CHAR = '-';

    @Override
    public String toString() {
        return name()
                .toLowerCase()
                .replace(REPLACE_CHAR, NEW_CHAR);
    }
}
