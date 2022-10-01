package com.br.healthCare.registrationService.infra.data;

import com.br.healthCare.registrationService.infra.data.medicalHistoryData.ContinuousUseMedicationsData;
import com.br.healthCare.registrationService.infra.data.medicalHistoryData.RelativesDiseasesData;
import com.br.healthCare.registrationService.infra.data.medicalHistoryData.SurgicalProceduresData;

import javax.persistence.*;
import java.util.List;
@Entity
public class MedicalHistoryData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer id;
    @ElementCollection
    private List<String> existingDiseases;
    @ElementCollection
    private List<String> limitations;
    private String bloodType;
    private List<SurgicalProceduresData> surgicalProcedureData;
    private List<ContinuousUseMedicationsData> continuousUseMedicationData;
    private String allergies;
    private boolean isSmoker;
    private boolean isPregnant;
    private List<RelativesDiseasesData> relativesDiseaseData;

    @OneToOne
    @JoinColumn(name="patient_id",  foreignKey = @ForeignKey(name = "patient_id"))
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

    public void setPatient(PatientData patientId) {
        this.patient = patient;
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

    @OneToMany
    @JoinColumn(name="surgicalProcedures_id", nullable = false)
    public List<SurgicalProceduresData> getSurgicalProcedures() {
        return surgicalProcedureData;
    }

    public void setSurgicalProcedures(List<SurgicalProceduresData> surgicalProcedureData) {
        this.surgicalProcedureData = surgicalProcedureData;
    }

    @OneToMany
    @JoinColumn(name="continuousUseMedications_id", nullable = false)
    public List<ContinuousUseMedicationsData> getContinuousUseMedications() {
        return continuousUseMedicationData;
    }

    public void setContinuousUseMedications(List<ContinuousUseMedicationsData> continuousUseMedicationData) {
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

    @OneToMany
    @JoinColumn(name="relativesDiseases_id", nullable = false)
    public List<RelativesDiseasesData> getRelativesDiseases() {
        return relativesDiseaseData;
    }


    public void setRelativesDiseases(List<RelativesDiseasesData> relativesDiseaseData) {
        this.relativesDiseaseData = relativesDiseaseData;
    }
}
