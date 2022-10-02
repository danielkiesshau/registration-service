package com.br.healthCare.registrationService.requests;

import com.br.healthCare.registrationService.requests.requestComplements.ContinuousUseMedications;
import com.br.healthCare.registrationService.requests.requestComplements.RelativesDiseases;
import com.br.healthCare.registrationService.requests.requestComplements.SurgicalProcedures;

import java.util.List;

public class MedicalHistoryRequest {
    public List<String> existingDiseases;
    public List<String> limitations;
    public String bloodType;
    public List<SurgicalProcedures> surgicalProcedures;
    public List<ContinuousUseMedications> continuousUseMedications;
    public String allergies;
    public boolean isSmoker;
    public boolean isPregnant;
    public List<RelativesDiseases> relativesDiseases;

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

    public List<SurgicalProcedures> getSurgicalProcedures() {
        return surgicalProcedures;
    }

    public void setSurgicalProcedures(List<SurgicalProcedures> surgicalProcedures) {
        this.surgicalProcedures = surgicalProcedures;
    }

    public List<ContinuousUseMedications> getContinuousUseMedications() {
        return continuousUseMedications;
    }

    public void setContinuousUseMedications(List<ContinuousUseMedications> continuousUseMedication) {
        this.continuousUseMedications = continuousUseMedication;
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

    public List<RelativesDiseases> getRelativesDiseases() {
        return relativesDiseases;
    }

    public void setRelativesDisease(List<RelativesDiseases> relativesDiseases) {
        this.relativesDiseases = relativesDiseases;
    }
}
