//package by.epam.medicines.builder;
//
//import by.epam.medicines.exception.MedicineException;
//
//public class MedicineBuilderFactory {
//    private enum TypeParser {
//        SAX, STAX, DOM
//    }
//
//
//    public static AbstractMedicineBuilder createBuilder(String typeParser) throws MedicineException {
//        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
//        switch (type) {
//            case DOM -> {
////                return new VoucherDOMBuilder();
//            }
//            case STAX -> {
////                return new VoucherStaxBuilder();
//            }
//            case SAX -> {
//                return new VoucherSaxBuilder();
//            }
//            default -> {
//                throw new MedicineException(String.format("No such constant (%s)", typeParser));
//            }
//        }
//    }
//}
