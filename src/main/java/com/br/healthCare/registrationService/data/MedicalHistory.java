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
    private SurgicalProcedures surgicalProcedures;
    private ContinuousUseMedications continuousUseMedications;
    private String allergies;
    private boolean isSmoker;
    private boolean isPregnant;
    private RelativesDiseases relativesDiseases;
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

    @OneToOne
    @JoinColumn(name="surgicalProcedures_id", nullable = false)
    public SurgicalProcedures getSurgicalProcedures() {
        return surgicalProcedures;
    }

    public void setSurgicalProcedures(SurgicalProcedures surgicalProcedures) {
        this.surgicalProcedures = surgicalProcedures;
    }

    @OneToOne
    @JoinColumn(name="continuousUseMedications_id", nullable = false)
    public ContinuousUseMedications getContinuousUseMedications() {
        return continuousUseMedications;
    }

    public void setContinuousUseMedications(ContinuousUseMedications continuousUseMedications) {
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

    @OneToOne
    @JoinColumn(name="relativesDiseases_id", nullable = false)
    public RelativesDiseases getRelativesDiseases() {
        return relativesDiseases;
    }


    public void setRelativesDiseases(RelativesDiseases relativesDiseases) {
        this.relativesDiseases = relativesDiseases;
    }
}
