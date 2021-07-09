package by.epam.medicines.entity;

public class Analog {
    private String analogName;

    public Analog() {
    }

    public Analog(String analogName) {
        this.analogName = analogName;
    }

    public String getAnalogName() {
        return analogName;
    }

    public void setAnalogName(String analogName) {
        this.analogName = analogName;
    }

    @Override
    public String toString() {
        return "Analog{" +
                "analogName='" + analogName + '\'' +
                '}';
    }
}
