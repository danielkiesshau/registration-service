package com.br.healthCare.registrationService.data;

import com.br.healthCare.registrationService.data.medicalHistoryData.ContinuousUseMedications;
import com.br.healthCare.registrationService.data.medicalHistoryData.RelativesDiseases;
import com.br.healthCare.registrationService.data.medicalHistoryData.SurgicalProcedures;

import javax.persistence.*;
import java.util.List;
@Entity
public class MedicalHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer id;
    @ElementCollection
    private List<String> existingDiseases;
    @ElementCollection
    private List<String> limitations;
    private String bloodType;
    private List<SurgicalProcedures> surgicalProcedures;
    private List<ContinuousUseMedications> continuousUseMedications;
    private String allergies;
    private boolean isSmoker;
    private boolean isPregnant;
    private List<RelativesDiseases> relativesDiseases;
    @OneToOne
    @JoinColumn(name = "patient_id", foreignKey = @ForeignKey(name = "id"))
    private Patient patientId;

    public Integer getId() {
        return id;
    }

    public MedicalHistory setId(Integer id) {
        this.id = id;
        return this;
    }

    public int getPatientId() {
        return patientId.getId();
    }

    public void setPatientId(Patient patient) {
        this.patientId = patientId;
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
    public List<SurgicalProcedures> getSurgicalProcedures() {
        return surgicalProcedures;
    }

    public void setSurgicalProcedures(List<SurgicalProcedures> surgicalProcedures) {
        this.surgicalProcedures = surgicalProcedures;
    }

    @OneToMany
    @JoinColumn(name="continuousUseMedications_id", nullable = false)
    public List<ContinuousUseMedications> getContinuousUseMedications() {
        return continuousUseMedications;
    }

    public void setContinuousUseMedications(List<ContinuousUseMedications> continuousUseMedications) {
        this.continuousUseMedications = continuousUseMedications;
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
    public List<RelativesDiseases> getRelativesDiseases() {
        return relativesDiseases;
    }


    public void setRelativesDiseases(List<RelativesDiseases> relativesDiseases) {
        this.relativesDiseases = relativesDiseases;
    }
}
