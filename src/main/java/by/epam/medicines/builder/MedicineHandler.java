//package by.epam.medicines.builder;
//
//import by.epam.medicines.entity.AbstractMedicine;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.xml.sax.Attributes;
//import org.xml.sax.SAXException;
//import org.xml.sax.helpers.DefaultHandler;
//
//import java.util.EnumSet;
//import java.util.HashSet;
//import java.util.Set;
//
//public class MedicineHandler extends DefaultHandler {
//    private static final char HYPHEN = '-';
//    private static final char UNDERSCORE = '_';
//    private static final Logger logger = LogManager.getLogger();
//
//    private Set<AbstractMedicine> medicines;
//    private EnumSet<MedicineXmlTag> tagsWithTextContent;
//    private AbstractMedicine currentMedicine;
//    private MedicineXmlTag currentTag;
//
//    public MedicineHandler() {
//        medicines = new HashSet<>();
//        tagsWithTextContent = EnumSet.range(MedicineXmlTag.NAME, MedicineXmlTag.ANALOG);
//    }
//
//    public Set<AbstractMedicine> getMedicines() {
//        return medicines;
//    }
//
//    @Override
//    public void startElement (String uri, String localName,
//                              String qName, Attributes attributes) throws SAXException {
//        String integralDeviceTag = DeviceXmlTag.INTEGRAL_DEVICE.toString();
//        String peripheralDeviceTag = DeviceXmlTag.PERIPHERAL_DEVICE.toString();
//
//        if (integralDeviceTag.equals(qName) || peripheralDeviceTag.equals(qName)) {
//            currentDevice = integralDeviceTag.equals(qName)
//                    ? new IntegralDevice()
//                    : new PeripheralDevice();
//
//            String idAttribute = DeviceXmlAttribute.ID.toString();
//            String manufacturerWebsiteAttribute = DeviceXmlAttribute.MANUFACTURER_WEBSITE.toString();
//            // added additional optional attribute to demonstrate proper parsing (including disordered attributes in xml)
//            String aliasAttribute = DeviceXmlAttribute.ALIAS.toString();
//
//            for (int i = 0; i < attributes.getLength(); i++) {
//                String attributeName = attributes.getQName(i);
//
//                if (attributeName.equals(idAttribute)) {
//                    String deviceId = attributes.getValue(i);
//                    currentDevice.setDeviceId(deviceId);
//                } else if (attributeName.equals(manufacturerWebsiteAttribute)) {
//                    String manufacturerWebsite = attributes.getValue(i);
//
//                    if (!manufacturerWebsite.isBlank()) {
//                        currentDevice.setManufacturerWebsite(manufacturerWebsite);
//                    }
//                } else if (attributeName.equals(aliasAttribute)) {
//                    String alias = attributes.getValue(i);
//
//                    if (!alias.isBlank()) {
//                        currentDevice.setAlias(alias);
//                    }
//                } else {
//                    logger.warn("Ignored unknown attribute: " + attributeName);
//                }
//            }
//        } else {
//            String constantName = toConstantName(qName);
//            DeviceXmlTag tag = DeviceXmlTag.valueOf(constantName);
//
//            if (tagsWithTextContent.contains(tag)) {
//                currentTag = tag;
//            }
//        }
//    }
//
//    @Override
//    public void endElement(String uri, String localName, String qName) {
//        String integralDeviceTag = DeviceXmlTag.INTEGRAL_DEVICE.toString();
//        String peripheralDeviceTag = DeviceXmlTag.PERIPHERAL_DEVICE.toString();
//
//        if (integralDeviceTag.equals(qName) || peripheralDeviceTag.equals(qName)) {
//            devices.add(currentDevice);
//            currentDevice = null;
//        }
//    }
//
//    @Override
//    public void characters(char[] ch, int start, int length) {
//        String data = new String(ch, start, length);
//
//        if (currentTag != null) {
//            switch (currentTag) {
//                case NAME -> currentDevice.setName(data);
//                case ORIGIN -> currentDevice.setOrigin(DeviceOrigin.valueOf(data));
//                case LAUNCH_TIME -> currentDevice.setLaunchTime(YearMonth.parse(data));
//                case PRICE -> currentDevice.setPrice(Integer.parseInt(data));
//                case POWER_CONSUMPTION -> currentDevice.setPowerConsumption(Integer.parseInt(data));
//                case COOLING -> currentDevice.setCooling(Boolean.parseBoolean(data));
//                case CRITICAL -> currentDevice.setCritical(Boolean.parseBoolean(data));
//                case INTEGRAL_DEVICE_TYPE -> {
//                    IntegralDevice device = (IntegralDevice) currentDevice;
//                    device.setDeviceType(IntegralDeviceType.valueOf(data));
//                }
//                case PERIPHERAL_DEVICE_TYPE -> {
//                    PeripheralDevice device = (PeripheralDevice) currentDevice;
//                    device.setDeviceType(PeripheralDeviceType.valueOf(data));
//                }
//                case PERIPHERAL_DEVICE_PORT -> {
//                    PeripheralDevice device = (PeripheralDevice) currentDevice;
//                    device.setDevicePort(PeripheralDevicePort.valueOf(data));
//                }
//                default -> throw new EnumConstantNotPresentException(
//                        currentTag.getDeclaringClass(), currentTag.name());
//            }
//        }
//
//        currentTag = null;
//    }
//
//    private String toConstantName(String string) {
//        return string.strip()
//                .replace(HYPHEN, UNDERSCORE)
//                .toUpperCase();
//    }
//}
