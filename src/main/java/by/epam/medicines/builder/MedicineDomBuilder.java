package by.epam.medicines.builder;

import by.epam.medicines.entity.*;
import by.epam.medicines.entity.Package;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MedicineDomBuilder {
    private Set<Medicine> medicines;
    private DocumentBuilder docBuilder;

    public MedicineDomBuilder() {
        medicines = new HashSet<>();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public Set<Medicine> getMedicines() {
        return medicines;
    }

    public void buildSetMedicines(String filename) {
        Document doc;
        try {
            doc = docBuilder.parse(filename);
            Element root = doc.getDocumentElement();
            NodeList medicinesList = root.getElementsByTagName(MedicineXmlTag.MEDICINE.toString());
            for (int i = 0; i < medicinesList.getLength(); i++) {
                Element medicineElement = (Element) medicinesList.item(i);
                Medicine medicine = buildMedicine(medicineElement);
                medicines.add(medicine);
            }
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private Medicine buildMedicine(Element medicineElement) {
        Medicine medicine = new Medicine();
        List<Analog> analogs = new ArrayList<>();
        List<Version> versions = new ArrayList<>();
        Certificate certificate = new Certificate();
        Package package1 = new Package();
        Dosage dosage = new Dosage();
        Version version = new Version();
        medicine.setId(medicineElement.getAttribute(MedicineXmlAttribute.ID.toString()));
        medicine.setName(getElementTextContent(medicineElement, MedicineXmlTag.NAME.toString()));
        medicine.setPharm(getElementTextContent(medicineElement, MedicineXmlTag.PHARM.toString()));
        medicine.setGroup(getElementTextContent(medicineElement, MedicineXmlTag.GROUP.toString()));

        NodeList analogElements = medicineElement.getElementsByTagName(MedicineXmlTag.ANALOG.toString());
        for (int i = 0; i < analogElements.getLength(); i++) {
            Element analogElement = (Element) analogElements.item(i);
            Analog analog = new Analog(getElementTextContent(analogElement, MedicineXmlTag.ANALOG_NAME.toString()));
            analogs.add(analog);
        }

        NodeList versionElements = medicineElement.getElementsByTagName(MedicineXmlTag.VERSION.toString());
        for (int i = 0; i < versionElements.getLength(); i++) {
            Element versionElement = (Element) versionElements.item(i);
            String form = getElementTextContent(versionElement, MedicineXmlTag.FORM.toString());
            version.setForm(form);


            NodeList certificateElements = versionElement.getElementsByTagName(MedicineXmlTag.CERTIFICATE.toString());
            for (int j = 0; j < certificateElements.getLength(); j++) {
                Element certificateElement = (Element) certificateElements.item(j);
                String number = getElementTextContent(certificateElement, MedicineXmlTag.NUMBER.toString());
                LocalDate issuance = LocalDate.parse(getElementTextContent(certificateElement, MedicineXmlTag.ISSUANCE.toString()));
                LocalDate expiration = LocalDate.parse(getElementTextContent(certificateElement, MedicineXmlTag.EXPIRATION.toString()));
                certificate.setNumber(number);
                certificate.setIssuance(issuance);
                certificate.setExpiration(expiration);
                version.setCertificate(certificate);
            }

            NodeList packageElements = versionElement.getElementsByTagName(MedicineXmlTag.PACKAGE.toString());
            for (int a = 0; a < packageElements.getLength(); a++) {
                Element packageElement = (Element) packageElements.item(a);
                String type = getElementTextContent(packageElement, MedicineXmlTag.TYPE.toString());
                int numberInPackage = Integer.parseInt(getElementTextContent(packageElement, MedicineXmlTag.NUMBER_IN_PACKAGE.toString()));
                double pricePerPackage = Double.parseDouble(getElementTextContent(packageElement, MedicineXmlTag.PRICE_PER_PACKAGE.toString()));
                package1.setType(type);
                package1.setNumberInPackage(numberInPackage);
                package1.setPricePerPackage(pricePerPackage);
                version.setPackage1(package1);
            }

            NodeList dosageElements = versionElement.getElementsByTagName(MedicineXmlTag.DOSAGE.toString());
            for (int b = 0; b < dosageElements.getLength(); b++) {
                Element dosageElement = (Element) dosageElements.item(b);
                double dose = Double.parseDouble(getElementTextContent(dosageElement, MedicineXmlTag.DRUG_DOSAGE.toString()));
                int receptionMultiplicity = Integer.parseInt(getElementTextContent(dosageElement, MedicineXmlTag.RECEPTION_MULTIPLICITY.toString()));
                dosage.setDose(dose);
                dosage.setReceptionMultiplicity(receptionMultiplicity);
                version.setDosage(dosage);
            }

        }
        versions.add(version);
        medicine.setAnalogs(analogs);
        medicine.setVersions(versions);
        return medicine;

    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }
}
