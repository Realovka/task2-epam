package by.epam.medicines.builder;

public enum MedicineXmlAttribute {
    ID,
    ORIGINAL;

    @Override
    public String toString() {
        return name()
                .toLowerCase();
    }
}
