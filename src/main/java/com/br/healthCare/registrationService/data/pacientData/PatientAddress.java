package com.br.healthCare.registrationService.data.pacientData;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class PatientAddress {
    private Integer id;

    private String locationName;
    private int zipCode;
    private String houseNumber;
    private String complement;

    public String getLocationName() {
        return locationName;
    }

    public PatientAddress setLocationName(String locationName) {
        this.locationName = locationName;
        return this;
    }

    public int getZipCode() {
        return zipCode;
    }

    public PatientAddress setZipCode(int zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public PatientAddress setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
        return this;
    }

    public String getComplement() {
        return complement;
    }

    public PatientAddress setComplement(String complement) {
        this.complement = complement;
        return this;
    }
}
