package by.epam.medicines.builder;

import by.epam.medicines.entity.Medicine;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class MedicineHandler extends DefaultHandler {

    private Set<Medicine> medicines;
    private String currentTagName;
    private Medicine currentMedicine;
    private EnumSet<MedicineXmlTag> withText;
    private boolean isMedicine;

    public MedicineHandler() {
        isMedicine = false;
        medicines = new HashSet<>();
        withText = EnumSet.range(MedicineXmlTag.NAME, MedicineXmlTag.RECEPTION_MULTIPLICITY);
    }

    public Set<Medicine> getMedicines() {
        return medicines;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentTagName = qName;
        if(currentTagName.equals(MedicineXmlTag.MEDICINE.toString())) {
            currentMedicine = new Medicine();
//            isMedicine = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
      if (qName.equals(MedicineXmlTag.MEDICINE.toString())) {
          medicines.add(currentMedicine);
//          isMedicine = false;
      }
      currentTagName = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String data = new String(ch, start, length).strip();
        if(currentTagName!=null) {
            switch (currentTagName) {
                case NAME : {
                    currentMedicine.setName(data);
                }
            }
        }
    }
}
