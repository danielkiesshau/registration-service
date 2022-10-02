package com.br.healthCare.registrationService.requests.requestComplements;

import com.br.healthCare.registrationService.infra.data.pacientData.PatientAddressData;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class PatientAddress {
    private String locationName;
    private int zipCode;
    private String houseNumber;
    private String complement;

    public String getLocationName() {
        return locationName;
    }

    private void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public int getZipCode() {
        return zipCode;
    }

    private void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    private void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getComplement() {
        return complement;
    }

    private void setComplement(String complement) {
        this.complement = complement;
    }

    public  static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private String locationName;
        private int zipCode;
        private String houseNumber;
        private String complement;

        public Builder withLocationName(String locationName){
            this.locationName = locationName;
            return this;
        }

        public Builder withzipCode(int zipCode){
            this.zipCode = zipCode;
            return this;
        }

        public Builder withHouseNumber(String houseNumber){
            this.houseNumber = houseNumber;
            return this;
        }

        public Builder withComplement(String complement){
            this.complement = complement;
            return this;
        }

        public PatientAddress build(){
            PatientAddress patientAddress = new PatientAddress();
            patientAddress.setLocationName(this.locationName);
            patientAddress.setZipCode(this.zipCode);
            patientAddress.setHouseNumber(this.houseNumber);
            patientAddress.setComplement(this.complement);

            return patientAddress;
        }
    }
}
