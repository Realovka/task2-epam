package by.epam.medicines.entity;

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
    public String toString() {
        return "Version{" +
                "form='" + form + '\'' +
                ", certificate=" + certificate +
                ", package1=" + package1 +
                ", dosage=" + dosage +
                '}';
    }
}
