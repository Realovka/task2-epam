package by.epam.medicines.entity;

import java.util.ArrayList;
import java.util.List;

public class Medicine {
    private String id;
    private String name;
    private String pharm;
    private String group;
    private List<Analog> analogs = new ArrayList<>();
    private List<Version> versions = new ArrayList<>();

    public Medicine() {
    }

    public Medicine(String id, String name, String pharm, String group, List<Analog> analogs, List<Version> versions) {
        this.id = id;
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
    public String toString() {
        return "Medicine{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", pharm='" + pharm + '\'' +
                ", group='" + group + '\'' +
                ", analogs=" + analogs +
                ", versions=" + versions +
                '}';
    }
}
