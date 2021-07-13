package by.epam.medicines.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Medicine {
    public static final String DEFAULT_ORIGINAL = "false";
    private String id;
    private String original;
    private String name;
    private String pharm;
    private String group;
    private List<Analog> analogs = new ArrayList<>();
    private List<Version> versions = new ArrayList<>();

    public Medicine() {
    }

    public Medicine(String id, String original, String name, String pharm, String group, List<Analog> analogs, List<Version> versions) {
        this.id = id;
        this.original = original;
        this.name = name;
        this.pharm = pharm;
        this.group = group;
        this.analogs = analogs;
        this.versions = versions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPharm() {
        return pharm;
    }

    public void setPharm(String pharm) {
        this.pharm = pharm;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public List<Analog> getAnalogs() {
        return analogs;
    }

    public void setAnalogs(List<Analog> analogs) {
        this.analogs = analogs;
    }

    public List<Version> getVersions() {
        return versions;
    }

    public void setVersions(List<Version> versions) {
        this.versions = versions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medicine medicine = (Medicine) o;
        return Objects.equals(id, medicine.id) &&
                Objects.equals(original, medicine.original) &&
                Objects.equals(name, medicine.name) &&
                Objects.equals(pharm, medicine.pharm) &&
                Objects.equals(group, medicine.group) &&
                Objects.equals(analogs, medicine.analogs) &&
                Objects.equals(versions, medicine.versions);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result *= 31 + (id != null ? id.hashCode() : 0);
        result *= 31 + (original != null ? original.hashCode() : 0);
        result *= 31 + (pharm != null ? pharm.hashCode() : 0);
        result *= 31 + (group != null ? group.hashCode() : 0);
        result *= 31 + (analogs != null ? analogs.hashCode() : 0);
        result *= 31 + (versions != null ? versions.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\nMedicine : \n\tid :").append(id);
        sb.append("\n\toriginal : ").append(original);
        sb.append("\n\tname : ").append(name);
        sb.append("\n\tpharm : ").append(pharm);
        sb.append("\n\tgroup : ").append(group);
        sb.append("\n\tanalogs : ").append(analogs);
        sb.append("\n\tversion : ").append(versions);
        sb.append('\n');
        return sb.toString();
    }
}
