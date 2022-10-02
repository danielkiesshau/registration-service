package com.br.healthCare.registrationService.infra.data.pacientData;


import javax.persistence.*;

@Entity
public class PatientAddressData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    private String locationName;
    private int zipCode;
    private String houseNumber;
    private String complement;

    public static Builder builder(){
        return new Builder();
    }

    public String getLocationName() {
        return locationName;
    }

    private PatientAddressData setLocationName(String locationName) {
        this.locationName = locationName;
        return this;
    }

    public int getZipCode() {
        return zipCode;
    }

    private PatientAddressData setZipCode(int zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    private PatientAddressData setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
        return this;
    }

    public String getComplement() {
        return complement;
    }

    private PatientAddressData setComplement(String complement) {
        this.complement = complement;
        return this;
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

        public PatientAddressData build(){
            PatientAddressData patientAddressData = new PatientAddressData();
            patientAddressData.setLocationName(this.locationName);
            patientAddressData.setZipCode(this.zipCode);
            patientAddressData.setHouseNumber(this.houseNumber);
            patientAddressData.setComplement(this.complement);

            return patientAddressData;
        }
    }
}
