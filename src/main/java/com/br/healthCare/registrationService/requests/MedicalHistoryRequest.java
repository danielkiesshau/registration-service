package com.br.healthCare.registrationService.requests;

import com.br.healthCare.registrationService.requests.requestComplements.ContinuousUseMedications;
import com.br.healthCare.registrationService.requests.requestComplements.RelativesDiseases;
import com.br.healthCare.registrationService.requests.requestComplements.SurgicalProcedures;

import java.util.List;

public class MedicalHistoryRequest {
    private String existingDiseases;
    private String limitations;
    private String bloodType;
    private List<SurgicalProcedures> surgicalProcedures;
    private List<ContinuousUseMedications> continuousUseMedications;
    private String allergies;
    private boolean isSmoker;
    private boolean isPregnant;
    private List<RelativesDiseases> relativesDiseases;
    private Integer patientId;
    private Integer id;

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

    public List<SurgicalProcedures> getSurgicalProcedures() {
        return surgicalProcedures;
    }

    private void setSurgicalProcedures(List<SurgicalProcedures> surgicalProcedures) {
        this.surgicalProcedures = surgicalProcedures;
    }

    public List<ContinuousUseMedications> getContinuousUseMedications() {
        return continuousUseMedications;
    }

    private void setContinuousUseMedications(List<ContinuousUseMedications> continuousUseMedication) {
        this.continuousUseMedications = continuousUseMedication;
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

    public List<RelativesDiseases> getRelativesDiseases() {
        return relativesDiseases;
    }

    private void setRelativesDiseases(List<RelativesDiseases> relativesDiseases) {
        this.relativesDiseases = relativesDiseases;
    }

    public Integer getPatientId() {
        return patientId;
    }

    private void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private String existingDiseases;
        private String limitations;
        private String bloodType;
        private List<SurgicalProcedures> surgicalProcedures;
        private List<ContinuousUseMedications> continuousUseMedications;
        private String allergies;
        private boolean isSmoker;
        private boolean isPregnant;
        private List<RelativesDiseases> relativesDiseases;
        private Integer patientId;
        private Integer id;

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

        public Builder withSurgicalProcedures(List<SurgicalProcedures> surgicalProcedures){
            this.surgicalProcedures = surgicalProcedures;
            return this;
        }

        public Builder withContinuousUseMedications(List<ContinuousUseMedications> continuousUseMedications){
            this.continuousUseMedications = continuousUseMedications;
            return this;
        }

        public Builder withRelativesDiseases(List<RelativesDiseases> relativesDiseases){
            this.relativesDiseases = relativesDiseases;
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

        public MedicalHistoryRequest build(){
            MedicalHistoryRequest response = new MedicalHistoryRequest();
            response.setExistingDiseases(this.existingDiseases);
            response.setAllergies(this.allergies);
            response.setLimitations(this.limitations);
            response.setPregnant(this.isPregnant);
            response.setSmoker(this.isSmoker);
            response.setBloodType(this.bloodType);
            response.setRelativesDiseases(this.relativesDiseases);
            response.setContinuousUseMedications(this.continuousUseMedications);
            response.setSurgicalProcedures(this.surgicalProcedures);
            response.setPatientId(this.patientId);
            response.setId(this.id);
            return response;
        }

    }
}
