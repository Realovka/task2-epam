package by.epam.medicines.entity;

public class Dosage {
    private double dose;
    private int receptionMultiplicity;

    public Dosage() {
    }

    public Dosage(double dose, int receptionMultiplicity) {
        this.dose = dose;
        this.receptionMultiplicity = receptionMultiplicity;
    }

    public double getDose() {
        return dose;
    }

    public void setDose(double dose) {
        this.dose = dose;
    }

    public int getReceptionMultiplicity() {
        return receptionMultiplicity;
    }

    public void setReceptionMultiplicity(int receptionMultiplicity) {
        this.receptionMultiplicity = receptionMultiplicity;
    }

    @Override
    public String toString() {
        return "Dosage{" +
                "dose=" + dose +
                ", receptionMultiplicity=" + receptionMultiplicity +
                '}';
    }
}
