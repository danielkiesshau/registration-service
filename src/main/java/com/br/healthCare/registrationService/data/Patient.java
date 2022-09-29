package com.br.healthCare.registrationService.data;



import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Patient {

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
    private int cpf;
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
    @JoinColumn(name = "address_id",
            foreignKey = @ForeignKey(name = "id")
    )

    @NotNull
    private com.br.healthCare.registrationService.data.pacientData.PatientAddress address;

    public com.br.healthCare.registrationService.data.pacientData.PatientAddress getAddress() {
        return address;
    }

    public Patient setAddress(com.br.healthCare.registrationService.data.pacientData.PatientAddress address) {
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

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getHealthInsuranceNumber() {
        return healthInsuranceNumber;
    }

    public void setHealthInsuranceNumber(int healthInsuranceNumber) {
        this.healthInsuranceNumber = healthInsuranceNumber;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }
}
