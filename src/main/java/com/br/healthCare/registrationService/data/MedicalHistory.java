package com.br.healthCare.registrationService.data;

import com.br.healthCare.registrationService.data.medicalHistoryData.ContinuousUseMedications;
import com.br.healthCare.registrationService.data.medicalHistoryData.RelativesDiseases;
import com.br.healthCare.registrationService.data.medicalHistoryData.SurgicalProcedures;

import java.util.List;

public class MedicalHistory {
    private List<String> existingDiseases;
    private List<String> limitations;
    private String bloodType;
    private SurgicalProcedures surgicalProcedures;
    private ContinuousUseMedications continuousUseMedications;
    private String allergies;
    private boolean isSmoker;
    private boolean isPregnant;
    private RelativesDiseases relativesDiseases;

    public List<String> getExistingDiseases() {
        return existingDiseases;
    }

    public MedicalHistory setExistingDiseases(List<String> existingDiseases) {
        this.existingDiseases = existingDiseases;
        return this;
    }

    public List<String> getLimitations() {
        return limitations;
    }

    public MedicalHistory setLimitations(List<String> limitations) {
        this.limitations = limitations;
        return this;
    }

    public String getBloodType() {
        return bloodType;
    }

    public MedicalHistory setBloodType(String bloodType) {
        this.bloodType = bloodType;
        return this;
    }

    public SurgicalProcedures getSurgicalProcedures() {
        return surgicalProcedures;
    }

    public MedicalHistory setSurgicalProcedures(SurgicalProcedures surgicalProcedures) {
        this.surgicalProcedures = surgicalProcedures;
        return this;
    }

    public ContinuousUseMedications getContinuousUseMedications() {
        return continuousUseMedications;
    }

    public MedicalHistory setContinuousUseMedications(ContinuousUseMedications continuousUseMedications) {
        this.continuousUseMedications = continuousUseMedications;
        return this;
    }

    public String getAllergies() {
        return allergies;
    }

    public MedicalHistory setAllergies(String allergies) {
        this.allergies = allergies;
        return this;
    }

    public boolean isSmoker() {
        return isSmoker;
    }

    public MedicalHistory setSmoker(boolean smoker) {
        isSmoker = smoker;
        return this;
    }

    public boolean isPregnant() {
        return isPregnant;
    }

    public MedicalHistory setPregnant(boolean pregnant) {
        isPregnant = pregnant;
        return this;
    }

    public RelativesDiseases getRelativesDiseases() {
        return relativesDiseases;
    }

    public MedicalHistory setRelativesDiseases(RelativesDiseases relativesDiseases) {
        this.relativesDiseases = relativesDiseases;
        return this;
    }
}
