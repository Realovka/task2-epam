package by.epam.medicines.entity;

import java.util.Objects;

public class Package {
    private String type;
    private int numberInPackage;
    private double pricePerPackage;

    public Package() {
    }

    public Package(String type, int numberInPackage, double pricePerPackage) {
        this.type = type;
        this.numberInPackage = numberInPackage;
        this.pricePerPackage = pricePerPackage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumberInPackage() {
        return numberInPackage;
    }

    public void setNumberInPackage(int numberInPackage) {
        this.numberInPackage = numberInPackage;
    }

    public double getPricePerPackage() {
        return pricePerPackage;
    }

    public void setPricePerPackage(double pricePerPackage) {
        this.pricePerPackage = pricePerPackage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Package aPackage = (Package) o;
        return numberInPackage == aPackage.numberInPackage &&
                Double.compare(aPackage.pricePerPackage, pricePerPackage) == 0 &&
                Objects.equals(type, aPackage.type);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = numberInPackage;
        result = (int) Double.doubleToLongBits(this.pricePerPackage);
        result *= 31 + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\nPackage : \n\ttype : ").append(type);
        sb.append("\n\tnumberInPackage : ").append(numberInPackage);
        sb.append("\n\tpricePerPackage : ").append(pricePerPackage);
        sb.append('\n');
        return sb.toString();
    }
}
