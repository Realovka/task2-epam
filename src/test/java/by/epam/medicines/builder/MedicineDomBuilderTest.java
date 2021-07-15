package by.epam.medicines.builder;

import by.epam.medicines.entity.Package;
import by.epam.medicines.entity.Analog;
import by.epam.medicines.entity.Medicine;
import by.epam.medicines.entity.Certificate;
import by.epam.medicines.entity.Version;
import by.epam.medicines.entity.Dosage;
import by.epam.medicines.exception.MedicineException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class MedicineDomBuilderTest {

    private static final String RELATIVE_FILE_PATH_TO_XML = "data/medicine_is_valid.xml";
    MedicineDomBuilder medicineDomBuilder;
    Set<Medicine> medicines;
    String pathToXml;

    @BeforeMethod
    public void setUp() throws MedicineException {
        pathToXml = ClassLoader.getSystemClassLoader().getResource(RELATIVE_FILE_PATH_TO_XML).getFile();
        medicineDomBuilder = new MedicineDomBuilder();
        medicines = new HashSet<>();
    }

    @Test
    public void testBuildMedicines() throws MedicineException{
        Set<Medicine> resultSet = new HashSet<>();
        medicineDomBuilder.buildMedicines(pathToXml);
        medicines = medicineDomBuilder.getMedicines();
        Analog analog = new Analog("Berlipril");
        Analog analog2 = new Analog("Enap");
        Certificate certificate = new Certificate("20/03/1371", LocalDate.of(2016, 6,2),
                LocalDate.of(2050, 1, 1));
        Package package1= new Package("blister", 30, 2.3);
        Dosage dosage = new Dosage(10, 1);
        Version version = new Version("tablet",  certificate, package1, dosage);
        Medicine medicine = new Medicine("id1", "false", "Enalapril-LF", "Lecfarm", "antihypertensive", List.of(analog, analog2),
                List.of(version));
        resultSet.add(medicine);
        assertEquals(medicines, resultSet);
    }

}