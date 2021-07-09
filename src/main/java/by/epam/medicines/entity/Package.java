package by.epam.medicines.entity;

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
    public String toString() {
        return "Package{" +
                "type='" + type + '\'' +
                ", numberInPackage=" + numberInPackage +
                ", pricePerPackage=" + pricePerPackage +
                '}';
    }
}
