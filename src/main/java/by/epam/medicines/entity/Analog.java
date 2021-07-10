package by.epam.medicines.entity;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Analog analog = (Analog) o;
        return Objects.equals(analogName, analog.analogName);
    }

    @Override
    public int hashCode() {
       return 31 + (analogName != null ? analogName.hashCode() : 0);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder().append("\nAnalog : \n\tanalogName : ").append(analogName);
        sb.append('\n');
        return sb.toString();
    }
}
