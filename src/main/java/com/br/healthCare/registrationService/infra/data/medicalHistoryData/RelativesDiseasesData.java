package com.br.healthCare.registrationService.infra.data.medicalHistoryData;

import com.br.healthCare.registrationService.infra.data.MedicalHistoryData;
import com.br.healthCare.registrationService.infra.data.PatientData;
import com.br.healthCare.registrationService.requests.requestComplements.RelativesDiseases;

import javax.persistence.*;

@Entity
public class RelativesDiseasesData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String kinshipDegree;
    private String diseaseName;

    @OneToOne
    @JoinColumn(name="patient.patient_id",  foreignKey = @ForeignKey(name = "patient.patient_id"))
    @MapsId
    private PatientData patient;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }


    public String getKinshipDegree() {
        return kinshipDegree;
    }

    public void setKinshipDegree(String kinshipDegree) {
        this.kinshipDegree = kinshipDegree;
    }

    public PatientData getPatient() {
        return patient;
    }

    public void setPatient(PatientData patient) {
        this.patient = patient;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private String kinshipDegree;
        private String diseaseName;
        public Integer patientId;


        public Builder withKinshipDegree(String kinshipDegree){
            this.kinshipDegree = kinshipDegree;
            return this;
        }

        public Builder withDiseaseName(String diseaseName){
            this.diseaseName = diseaseName;
            return this;
        }

        public Builder withPatientId(Integer patientId){
            this.patientId = patientId;
            return this;
        }


        public RelativesDiseasesData build(){
            RelativesDiseasesData response = new RelativesDiseasesData();
            response.setDiseaseName(this.diseaseName);
            response.setKinshipDegree(this.kinshipDegree);
            PatientData patientData = new PatientData();
            patientData.setId(this.patientId);
            response.setPatient(patientData);

            return response;
        }
    }
}
