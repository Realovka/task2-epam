package by.epam.medicines.exception;

public class MedicineException extends Exception{
    public MedicineException() {
    }

    public MedicineException(String message) {
        super(message);
    }

    public MedicineException(String message, Throwable cause) {
        super(message, cause);
    }

    public MedicineException(Throwable cause) {
        super(cause);
    }
}
