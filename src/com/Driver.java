package com;

public class Driver extends BaseEntity {
    private String name;
    private String licenseNumber;

    // Constructor, getters, and setters
    // ...
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

}
