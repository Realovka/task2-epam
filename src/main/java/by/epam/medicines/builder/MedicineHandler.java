package by.epam.medicines.builder;

import by.epam.medicines.entity.*;
import by.epam.medicines.entity.Package;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.time.LocalDate;
import java.util.*;

public class MedicineHandler extends DefaultHandler {

    private Set<Medicine> medicines;
    private List<Version> versions;
    private Analog currentAnalog;
    private Version currentVersion;
    private Certificate currentCertificate;
    private Package currentPackage;
    private Medicine currentMedicine;
    private Dosage currentDosage;
    private EnumSet<MedicineXmlTag> withText;
    private MedicineXmlTag currentTagName;
    private static final char REPLACE_CHAR = '-';
    private static final char NEW_CHAR = '_';

    public MedicineHandler() {
        medicines = new HashSet<>();
        versions = new ArrayList<>();
        withText = EnumSet.range(MedicineXmlTag.NAME, MedicineXmlTag.RECEPTION_MULTIPLICITY);
    }

    public Set<Medicine> getMedicines() {
        return medicines;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentTagName = updateQName(qName);
        switch (currentTagName) {
            case MEDICINE: {
                currentMedicine = new Medicine();
                break;
            }
            case ANALOG: {
                currentAnalog = new Analog();
                break;
            }
            case VERSION: {
                currentVersion = new Version();
                break;
            }
            case CERTIFICATE: {
                currentCertificate = new Certificate();
                break;
            }
            case PACKAGE: {
                currentPackage = new Package();
                break;
            }
            case DOSAGE: {
                currentDosage = new Dosage();
                break;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (updateQName(qName)) {
            case MEDICINE: {
                medicines.add(currentMedicine);
                break;
            }
            case ANALOG: {
                currentMedicine.getAnalogs().add(currentAnalog);
                break;
            }
            case CERTIFICATE: {
                currentVersion.setCertificate(currentCertificate);
                break;
            }
            case PACKAGE: {
                currentVersion.setPackage1(currentPackage);
                break;
            }
            case DOSAGE: {
                currentVersion.setDosage(currentDosage);
                currentMedicine.getVersions().add(currentVersion);
                break;
            }
        }
        currentTagName = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String data = new String(ch, start, length).strip();
        if (currentTagName != null) {
            switch (currentTagName) {
                case NAME: {
                    currentMedicine.setName(data);
                    break;
                }
                case PHARM: {
                    currentMedicine.setPharm(data);
                    break;
                }
                case GROUP: {
                    currentMedicine.setGroup(data);
                    break;
                }
                case ANALOG_NAME: {
                    currentAnalog.setAnalogName(data);
                    break;
                }
                case FORM: {
                    currentVersion.setForm(data);
                    break;
                }
                case NUMBER: {
                    currentCertificate.setNumber(data);
                    break;
                }
                case ISSUANCE: {
                    currentCertificate.setIssuance(LocalDate.parse(data));
                    break;
                }
                case EXPIRATION: {
                    currentCertificate.setExpiration(LocalDate.parse(data));
                    break;
                }
                case TYPE: {
                    currentPackage.setType(data);
                    break;
                }
                case NUMBER_IN_PACKAGE: {
                    currentPackage.setNumberInPackage(Integer.parseInt(data));
                    break;
                }
                case PRICE_PER_PACKAGE: {
                    currentPackage.setPricePerPackage(Double.parseDouble(data));
                    break;
                }
                case DRUG_DOSAGE: {
                    currentDosage.setDose(Double.parseDouble(data));
                    break;
                }
                case RECEPTION_MULTIPLICITY: {
                    currentDosage.setReceptionMultiplicity(Integer.parseInt(data));
                    break;
                }
            }
        }
    }

    private MedicineXmlTag updateQName(String qName) {
        String newQName = qName.toUpperCase().replace(REPLACE_CHAR, NEW_CHAR);
        return MedicineXmlTag.valueOf(newQName);
    }
}

