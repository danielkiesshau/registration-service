package com.br.healthCare.registrationService.data;

import com.br.healthCare.registrationService.data.pacientData.PatientAddress;

public class Patient {
    private String name;
    private String genre;
    private int age;
    private String weight;
    private int cpf;
    private String phoneNumber;
    private String email;
    private int healtInsuranceNumber;
    private String fatherName;
    private String motherName;
    private PatientAddress address;

    public String getName() {
        return name;
    }

    public Patient setName(String name) {
        this.name = name;
        return this;
    }

    public String getGenre() {
        return genre;
    }

    public Patient setGenre(String genre) {
        this.genre = genre;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Patient setAge(int age) {
        this.age = age;
        return this;
    }

    public String getWeight() {
        return weight;
    }

    public Patient setWeight(String weight) {
        this.weight = weight;
        return this;
    }

    public int getCpf() {
        return cpf;
    }

    public Patient setCpf(int cpf) {
        this.cpf = cpf;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Patient setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Patient setEmail(String email) {
        this.email = email;
        return this;
    }

    public int getHealtInsuranceNumber() {
        return healtInsuranceNumber;
    }

    public Patient setHealtInsuranceNumber(int healtInsuranceNumber) {
        this.healtInsuranceNumber = healtInsuranceNumber;
        return this;
    }

    public String getFatherName() {
        return fatherName;
    }

    public Patient setFatherName(String fatherName) {
        this.fatherName = fatherName;
        return this;
    }

    public String getMotherName() {
        return motherName;
    }

    public Patient setMotherName(String motherName) {
        this.motherName = motherName;
        return this;
    }

    public PatientAddress getAddress() {
        return address;
    }

    public Patient setAddress(PatientAddress address) {
        this.address = address;
        return this;
    }
}
