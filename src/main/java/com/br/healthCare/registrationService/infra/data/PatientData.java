package com.br.healthCare.registrationService.infra.data;



import com.br.healthCare.registrationService.infra.data.pacientData.PatientAddressData;
import com.br.healthCare.registrationService.requests.requestComplements.PatientAddress;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class PatientData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private String genre;
    @NotNull
    private int age;
    @NotNull
    private String weight;
    @NotNull
    @Column(unique = true)
    private String cpf;
    @NotNull
    private String phoneNumber;
    @NotNull
    private String email;
    @NotNull
    private int healthInsuranceNumber;
    @NotNull
    private String fatherName;

    @NotNull
    private String motherName;

    @OneToOne
    @JoinColumn(name = "address_id")
    @NotNull
    private PatientAddressData address;

    public PatientAddressData getAddress() {
        return address;
    }

    public PatientData setAddress(PatientAddressData address) {
        this.address = address;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    private void setGenre(String genre) {
        this.genre = genre;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public String getWeight() {
        return weight;
    }

    private void setWeight(String weight) {
        this.weight = weight;
    }

    public String getCpf() {
        return cpf;
    }

    private void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    private void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    public int getHealthInsuranceNumber() {
        return healthInsuranceNumber;
    }

    private void setHealthInsuranceNumber(int healthInsuranceNumber) {
        this.healthInsuranceNumber = healthInsuranceNumber;
    }

    public String getFatherName() {
        return fatherName;
    }

    private void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    private void setMotherName(String motherName) {
        this.motherName = motherName;
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
        private PatientAddressData patientAddress;

        public Builder withName(String name){
            this.name=name;
            return this;
        }

        public  Builder withGenre(String genre){
            this.genre=genre;
            return this;
        }

        public  Builder withAge(Integer age){
            this.age=age;
            return this;
        }

        public  Builder withCpf(String weight){
            this.weight=weight;
            return this;
        }

        public  Builder withWeight(String cpf){
            this.cpf=cpf;
            return this;
        }

        public  Builder withPhoneNumber(String phoneNumber){
            this.phoneNumber=phoneNumber;
            return this;
        }

        public  Builder withEmail(String email){
            this.email=email;
            return this;
        }

        public  Builder withInsuranceNumber(Integer insuranceNumber){
            this.healthInsuranceNumber=insuranceNumber;
            return this;
        }

        public  Builder withFatherName(String fatherName){
            this.fatherName=fatherName;
            return this;
        }

        public  Builder withMotherName(String motherName){
            this.motherName=motherName;
            return this;
        }

        public  Builder withAddress(PatientAddress patientAddress){
            this.patientAddress = PatientAddressData
                    .builder()
                    .withLocationName(patientAddress.getLocationName())
                    .withzipCode(patientAddress.getZipCode())
                    .withHouseNumber(patientAddress.getHouseNumber())
                    .withComplement(patientAddress.getComplement())
                    .build();
            return this;
        }

        public  PatientData build(){
            PatientData patientData = new PatientData();
            patientData.setName(this.name);
            patientData.setGenre(this.genre);
            patientData.setAge(this.age);
            patientData.setWeight(this.weight);
            patientData.setCpf(this.cpf);
            patientData.setPhoneNumber(this.phoneNumber);
            patientData.setEmail(this.email);
            patientData.setHealthInsuranceNumber(this.healthInsuranceNumber);
            patientData.setFatherName(this.fatherName);
            patientData.setMotherName(this.motherName);
            patientData.setAddress(this.patientAddress);

            return patientData;
        }

    }
}


