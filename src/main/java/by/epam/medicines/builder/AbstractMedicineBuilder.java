package by.epam.medicines.builder;

import by.epam.medicines.entity.Medicine;
import by.epam.medicines.exception.MedicineException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
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

    public abstract void buildMedicine(String xmlPath) throws MedicineException, ParserConfigurationException, SAXException;
}
