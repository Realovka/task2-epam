package by.epam.medicines.entity;

import java.util.Objects;

public class Version {
    private String form;
    private Certificate certificate;
    private Package package1;
    private Dosage dosage;

    public Version() {
    }

    public Version(String form, Certificate certificate, Package package1, Dosage dosage) {
        this.form = form;
        this.certificate = certificate;
        this.package1 = package1;
        this.dosage = dosage;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    public Package getPackage1() {
        return package1;
    }

    public void setPackage1(Package package1) {
        this.package1 = package1;
    }

    public Dosage getDosage() {
        return dosage;
    }

    public void setDosage(Dosage dosage) {
        this.dosage = dosage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Version version = (Version) o;
        return Objects.equals(form, version.form) &&
                Objects.equals(certificate, version.certificate) &&
                Objects.equals(package1, version.package1) &&
                Objects.equals(dosage, version.dosage);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result *= 31 + (form != null ? form.hashCode() : 0);
        result *= 31 + (package1 != null ? package1.hashCode() : 0);
        result *= 31 + (dosage != null ? dosage.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder().append("\nVersion :\n\tform : ");
        sb.append(form).append("\n\tcertificate : ").append(certificate);
        sb.append("\n\tpackage : ").append(package1);
        sb.append("\n\tdosage : ").append(dosage);
        sb.append('\n');
        return sb.toString();
    }
}
