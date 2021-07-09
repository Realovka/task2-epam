package by.epam.medicines.entity;

import java.time.LocalDate;

public class Certificate {
    private String number;
    private LocalDate issuance;
    private LocalDate expiration;

    public Certificate() {
    }

    public Certificate(String number, LocalDate issuance, LocalDate expiration) {
        this.number = number;
        this.issuance = issuance;
        this.expiration = expiration;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getIssuance() {
        return issuance;
    }

    public void setIssuance(LocalDate issuance) {
        this.issuance = issuance;
    }

    public LocalDate getExpiration() {
        return expiration;
    }

    public void setExpiration(LocalDate expiration) {
        this.expiration = expiration;
    }

    @Override
    public String toString() {
        return "Certificate{" +
                "number='" + number + '\'' +
                ", issuance=" + issuance +
                ", expiration=" + expiration +
                '}';
    }
}
