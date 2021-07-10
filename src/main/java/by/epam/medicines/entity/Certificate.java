package by.epam.medicines.entity;

import java.time.LocalDate;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Certificate that = (Certificate) o;
        return Objects.equals(number, that.number) &&
                Objects.equals(issuance, that.issuance) &&
                Objects.equals(expiration, that.expiration);
    }

    @Override
    public int hashCode() {
       int result = 1;
       result *= 31 + (number != null ? number.hashCode() : 0);
       result *= 31 + (issuance != null ? issuance.hashCode() : 0);
       result *= 31 + (expiration != null ? expiration.hashCode() : 0);
       return  result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder().append("\nCertificate : \n\tnumber").append(number);
        sb.append("\n\tissuance : ").append(issuance);
        sb.append("\n\texpiration : ").append(expiration);
        sb.append('\n');
        return sb.toString();
    }
}
