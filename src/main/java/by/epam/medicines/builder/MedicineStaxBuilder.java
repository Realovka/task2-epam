package by.epam.medicines.builder;

import by.epam.medicines.entity.Analog;
import by.epam.medicines.entity.Certificate;
import by.epam.medicines.entity.Medicine;
import by.epam.medicines.entity.Version;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MedicineStaxBuilder {
    private static final Logger logger = LogManager.getLogger();
    private Set<Medicine> medicines;
    private XMLInputFactory inputFactory;
    private static final char REPLACE_CHAR = '-';
    private static final char NEW_CHAR = '_';

    public MedicineStaxBuilder() {
        inputFactory = XMLInputFactory.newInstance();
        medicines = new HashSet<>();
    }

    public Set<Medicine> getMedicines() {
        return medicines;
    }

    public void buildSetMedicines(String filename) {
        XMLStreamReader reader;
        String name;
        try (FileInputStream inputStream = new FileInputStream(new File(filename))) {
            reader = inputFactory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (name.equals(MedicineXmlTag.MEDICINE.toString())) {
                        Medicine medicine = buildMedicine(reader);
                        medicines.add(medicine);
                    }
                }
            }
        } catch (XMLStreamException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Medicine buildMedicine(XMLStreamReader reader) throws XMLStreamException {
        Medicine medicine = new Medicine();
        medicine.setAnalogs(new ArrayList<>());
        medicine.setName(reader.getAttributeValue(null, MedicineXmlTag.NAME.toString()));
        medicine.setPharm(reader.getAttributeValue(null, MedicineXmlTag.PHARM.toString()));
        medicine.setGroup(reader.getAttributeValue(null, MedicineXmlTag.GROUP.toString()));
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = updateName(reader.getLocalName());
                    switch (MedicineXmlTag.valueOf(name)) {
                        case NAME: {
                            medicine.setName(getXMLText(reader));
                            break;
                        }
                        case PHARM: {
                            medicine.setPharm(getXMLText(reader));
                            break;
                        }
                        case GROUP: {
                            medicine.setGroup(getXMLText(reader));
                            break;
                        }
                        case ANALOG: {
                            medicine.getAnalogs().add(getAnalog(reader));
                            break;
                        }
                        case VERSION: {
                            medicine.getVersions().add(getVersion(reader));
                            break;
                        }
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = updateName(reader.getLocalName());
                    if (MedicineXmlTag.valueOf(name) == MedicineXmlTag.MEDICINE) {
                        return medicine;
                    }
            }
        }
        throw new XMLStreamException("Unknown element in tag <medicine>");
    }

    private Analog getAnalog(XMLStreamReader reader) throws XMLStreamException {
        Analog analog = new Analog();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = updateName(reader.getLocalName());
                    switch (MedicineXmlTag.valueOf(name)) {
                        case ANALOG_NAME:
                            analog.setAnalogName(getXMLText(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = updateName(reader.getLocalName());
                    if (MedicineXmlTag.valueOf(name) == MedicineXmlTag.ANALOG) {
                        return analog;
                    }
            }
        }
        throw new XMLStreamException("Unknown element in tag <analog>");
    }

    private Version getVersion(XMLStreamReader reader) throws XMLStreamException {
        Version version = new Version();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = updateName(reader.getLocalName());
                    switch (MedicineXmlTag.valueOf(name)) {
                        case FORM:
                            version.setForm(getXMLText(reader));
                            break;
                        case CERTIFICATE:
                            version.setCertificate(getCertificate(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = updateName(reader.getLocalName());
                    if (MedicineXmlTag.valueOf(name) == MedicineXmlTag.VERSION) {
                        return version;
                    }
            }
        }
        throw new XMLStreamException("Unknown element in tag <version>");
    }

    private Certificate getCertificate(XMLStreamReader reader) throws XMLStreamException {
        Certificate certificate = new Certificate();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = updateName(reader.getLocalName());
                    switch (MedicineXmlTag.valueOf(name)) {
                        case NUMBER:
                            certificate.setNumber(getXMLText(reader));
                            break;
                        case ISSUANCE:
                            certificate.setIssuance(LocalDate.parse(getXMLText(reader)));
                            break;
                        case EXPIRATION:
                            certificate.setExpiration(LocalDate.parse(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = updateName(reader.getLocalName());
                    if (MedicineXmlTag.valueOf(name) == MedicineXmlTag.CERTIFICATE) {
                        return certificate;
                    }
            }
        }
        throw new XMLStreamException("Unknown element in tag <version>");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }

    private String updateName(String name) {
        return name.toUpperCase().replace(REPLACE_CHAR, NEW_CHAR);
    }
}
