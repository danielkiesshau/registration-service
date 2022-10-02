package com.br.healthCare.registrationService.infra.data;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;
@Entity
public class MedicalHistoryData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id", unique = true, nullable = false)    private Integer id;
    private String existingDiseases;
    private String limitations;
    private String bloodType;
    private String allergies;
    private boolean isSmoker;
    private boolean isPregnant;

    @OneToOne(cascade = CascadeType.REMOVE,orphanRemoval =true )
    @JoinColumn(name = "patient_data_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private PatientData patient;

    public Integer getId() {
        return id;
    }

    public MedicalHistoryData setId(Integer id) {
        this.id = id;
        return this;
    }

    public PatientData getPatient() {
        return patient;
    }

    private void setPatient(PatientData patientId) {
        this.patient = patientId;
    }

    public String getExistingDiseases() {
        return existingDiseases;
    }

    private void setExistingDiseases(String existingDiseases) {
        this.existingDiseases = existingDiseases;
    }

    public String getLimitations() {
        return limitations;
    }

    private void setLimitations(String limitations) {
        this.limitations = limitations;
    }

    public String getBloodType() {
        return bloodType;
    }

    private void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getAllergies() {
        return allergies;
    }

    private void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public boolean isSmoker() {
        return isSmoker;
    }

    private void setSmoker(boolean smoker) {
        isSmoker = smoker;
    }

    public boolean isPregnant() {
        return isPregnant;
    }

    private void setPregnant(boolean pregnant) {
        isPregnant = pregnant;
    }


    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        public String existingDiseases;
        public String limitations;
        public String bloodType;
        public String allergies;
        public boolean isSmoker;
        public boolean isPregnant;
        public Integer patientId;
        public Integer id;

        public Builder withExistingDiseases(String existingDiseases){
            this.existingDiseases = existingDiseases;
            return this;
        }

        public Builder withLimitations(String limitations){
            this.limitations = limitations;
            return this;
        }

        public Builder withBloodType(String bloodType){
            this.bloodType = bloodType;
            return this;
        }

        public Builder withAllergies(String allergies){
            this.allergies = allergies;
            return this;
        }

        public Builder isSmoker(Boolean isSmoker){
            this.isSmoker = isSmoker;
            return this;
        }

        public Builder isPregnant(Boolean isPregnant){
            this.isPregnant = isPregnant;
            return this;
        }

        public Builder withPatientId(Integer patientId){
            this.patientId = patientId;
            return this;
        }

        public Builder withId(Integer id){
            this.id = id;
            return this;
        }

        public MedicalHistoryData build(){
            MedicalHistoryData response = new MedicalHistoryData();
            response.setExistingDiseases(this.existingDiseases);
            response.setAllergies(this.allergies);
            response.setLimitations(this.limitations);
            response.setPregnant(this.isPregnant);
            response.setSmoker(this.isSmoker);
            response.setBloodType(this.bloodType);
            PatientData patientData = new PatientData();
            patientData.setId(this.patientId);
            response.setPatient(patientData);
            if(this.id != null && this.id !=0) {
                response.setId(this.id);
            }

            return response;
        }
    }
}
