package com.br.healthCare.registrationService.requests;


import com.br.healthCare.registrationService.infra.data.PatientData;
import com.br.healthCare.registrationService.infra.data.pacientData.PatientAddressData;
import com.br.healthCare.registrationService.requests.requestComplements.PatientAddress;

public class PatientRequest {

    private String name;
    private String genre;
    private int age;
    private String weight;
    private String cpf;
    private String phoneNumber;
    private String email;
    private int healthInsuranceNumber;
    private String fatherName;
    private String motherName;
    private PatientAddress address;

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public int getAge() {
        return age;
    }

    public String getWeight() {
        return weight;
    }

    public String getCpf() {
        return cpf;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public int getHealthInsuranceNumber() {
        return healthInsuranceNumber;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public PatientAddress getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHealthInsuranceNumber(int healthInsuranceNumber) {
        this.healthInsuranceNumber = healthInsuranceNumber;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public void setAddress(PatientAddress address) {
        this.address = address;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private String name;
        private String genre;
        private Integer age;
        private String weight;
        private String cpf;
        private String phoneNumber;
        private String email;
        private Integer healthInsuranceNumber;
        private String fatherName;
        private String motherName;
        private PatientAddress patientAddress;

        public Builder withName(String name){
            this.name=name;
            return this;
        }

        public Builder withGenre(String genre){
            this.genre=genre;
            return this;
        }

        public Builder withAge(Integer age){
            this.age=age;
            return this;
        }

        public Builder withCpf(String weight){
            this.weight=weight;
            return this;
        }

        public Builder withWeight(String cpf){
            this.cpf=cpf;
            return this;
        }

        public Builder withPhoneNumber(String phoneNumber){
            this.phoneNumber=phoneNumber;
            return this;
        }

        public Builder withEmail(String email){
            this.email=email;
            return this;
        }

        public Builder withInsuranceNumber(Integer insuranceNumber){
            this.healthInsuranceNumber=insuranceNumber;
            return this;
        }

        public Builder withFatherName(String fatherName){
            this.fatherName=fatherName;
            return this;
        }

        public Builder withMotherName(String motherName){
            this.motherName=motherName;
            return this;
        }

        public Builder withAddress(PatientAddressData patientAddress){
            this.patientAddress = PatientAddress
                    .builder()
                    .withLocationName(patientAddress.getLocationName())
                    .withzipCode(patientAddress.getZipCode())
                    .withHouseNumber(patientAddress.getHouseNumber())
                    .withComplement(patientAddress.getComplement())
                    .build();
            return this;
        }

        public  PatientRequest build(){
            PatientRequest patientRequest = new PatientRequest();
            patientRequest.setName(this.name);
            patientRequest.setGenre(this.genre);
            patientRequest.setAge(this.age);
            patientRequest.setWeight(this.weight);
            patientRequest.setCpf(this.cpf);
            patientRequest.setPhoneNumber(this.phoneNumber);
            patientRequest.setEmail(this.email);
            patientRequest.setHealthInsuranceNumber(this.healthInsuranceNumber);
            patientRequest.setFatherName(this.fatherName);
            patientRequest.setMotherName(this.motherName);
            patientRequest.setAddress(this.patientAddress);

            return patientRequest;
        }

    }
}
