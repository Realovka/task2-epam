package by.epam.medicines.builder;

import by.epam.medicines.entity.Medicine;
import by.epam.medicines.exception.MedicineException;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractMedicineBuilder {
    protected Set<Medicine> medicines;

    public AbstractMedicineBuilder() {
        medicines = new HashSet<>();
    }

    public Set<Medicine> getMedicines() {
        return medicines;
    }

    public abstract void buildMedicines(String xmlPath) throws MedicineException;
}
