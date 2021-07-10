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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dosage dosage = (Dosage) o;
        return Double.compare(dosage.dose, dose) == 0 &&
                receptionMultiplicity == dosage.receptionMultiplicity;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = (int) Double.doubleToLongBits(this.dose);
        result = receptionMultiplicity;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\nDosage:\n\tdose: ").append(dose);
        sb.append("\n\treceptionMultiplicity: ").append(receptionMultiplicity);
        sb.append('\n');
        return sb.toString();
    }
}
