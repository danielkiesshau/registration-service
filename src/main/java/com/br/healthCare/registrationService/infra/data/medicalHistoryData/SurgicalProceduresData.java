package com.br.healthCare.registrationService.infra.data.medicalHistoryData;

import com.br.healthCare.registrationService.infra.data.MedicalHistoryData;
import com.br.healthCare.registrationService.infra.data.PatientData;
import com.br.healthCare.registrationService.requests.requestComplements.SurgicalProcedures;

import javax.persistence.*;
import java.util.Date;

@Entity
public class SurgicalProceduresData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String procedureName;
    private String complications;
    private Date date;

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

    public String getProcedureName() {
        return procedureName;
    }

    public SurgicalProceduresData setProcedureName(String procedureName) {
        this.procedureName = procedureName;
        return this;
    }

    public String getComplications() {
        return complications;
    }

    public SurgicalProceduresData setComplications(String complications) {
        this.complications = complications;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public SurgicalProceduresData setDate(Date date) {
        this.date = date;
        return this;
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
        private String procedureName;
        private String complications;
        private Date date;
        public Integer patientId;


        public Builder withProcedureName(String procedureName){
            this.procedureName = procedureName;
            return this;
        }

        public Builder withComplications(String complications){
            this.complications = complications;
            return this;
        }

        public Builder withDate(Date date){
            this.date = date;
            return this;
        }

        public Builder withPatientId(Integer patientId){
            this.patientId = patientId;
            return this;
        }


        public SurgicalProceduresData build(){
            SurgicalProceduresData response = new SurgicalProceduresData();
            response.setProcedureName(this.procedureName);
            response.setComplications(this.complications);
            response.setDate(this.date);
            PatientData patientData = new PatientData();
            patientData.setId(this.patientId);
            response.setPatient(patientData);

            return response;
        }
    }
}
