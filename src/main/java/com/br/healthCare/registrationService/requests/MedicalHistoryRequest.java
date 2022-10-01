package com.br.healthCare.registrationService.requests;

import com.br.healthCare.registrationService.requests.requestComplements.ContinuousUseMedications;
import com.br.healthCare.registrationService.requests.requestComplements.RelativesDiseases;
import com.br.healthCare.registrationService.requests.requestComplements.SurgicalProcedures;

import java.util.List;

public class MedicalHistoryRequest {
    public List<String> existingDiseases;
    public List<String> limitations;
    public String bloodType;
    public List<SurgicalProcedures> surgicalProcedureData;
    public List<ContinuousUseMedications> continuousUseMedicationData;
    public String allergies;
    public boolean isSmoker;
    public boolean isPregnant;
    public List<RelativesDiseases> relativesDiseaseData;

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

    public List<SurgicalProcedures> getSurgicalProcedureData() {
        return surgicalProcedureData;
    }

    public void setSurgicalProcedureData(List<SurgicalProcedures> surgicalProcedureData) {
        this.surgicalProcedureData = surgicalProcedureData;
    }

    public List<ContinuousUseMedications> getContinuousUseMedicationData() {
        return continuousUseMedicationData;
    }

    public void setContinuousUseMedicationData(List<ContinuousUseMedications> continuousUseMedicationData) {
        this.continuousUseMedicationData = continuousUseMedicationData;
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

    public List<RelativesDiseases> getRelativesDiseaseData() {
        return relativesDiseaseData;
    }

    public void setRelativesDiseaseData(List<RelativesDiseases> relativesDiseaseData) {
        this.relativesDiseaseData = relativesDiseaseData;
    }
}
