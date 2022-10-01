package com.br.healthCare.registrationService.domain.controllers.contracts;

import com.br.healthCare.registrationService.data.Patient;
import com.br.healthCare.registrationService.data.medicalHistoryData.ContinuousUseMedications;
import com.br.healthCare.registrationService.data.medicalHistoryData.RelativesDiseases;
import com.br.healthCare.registrationService.data.medicalHistoryData.SurgicalProcedures;

import javax.persistence.*;
import java.util.List;

public class GetMedicalHistoryRequest {

    private Integer id;
    private List<String> existingDiseases;
    private List<String> limitations;
    private String bloodType;
    private String allergies;
    private boolean isSmoker;
    private boolean isPregnant;
    private Patient patientId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<String> getExistingDiseases() {
        return existingDiseases;
    }

    public void setExistingDiseases(List<String> existingDiseases) {
        this.existingDiseases = existingDiseases;
    }

    public List<String> getLimitations() {
        return limitations;
    }

    public void setLimitations(List<String> limitations) {
        this.limitations = limitations;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public boolean isSmoker() {
        return isSmoker;
    }

    public void setSmoker(boolean smoker) {
        isSmoker = smoker;
    }

    public boolean isPregnant() {
        return isPregnant;
    }

    public void setPregnant(boolean pregnant) {
        isPregnant = pregnant;
    }

    public Integer getPatientId() {
        return patientId.getId();
    }

    public void setPatientId(Patient patientId) {
        this.patientId = patientId;
    }
}
