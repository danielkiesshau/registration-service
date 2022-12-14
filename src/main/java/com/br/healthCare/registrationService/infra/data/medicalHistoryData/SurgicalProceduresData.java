package com.br.healthCare.registrationService.infra.data.medicalHistoryData;

import com.br.healthCare.registrationService.infra.data.PatientData;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
public class SurgicalProceduresData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    private String procedureName;
    private String complications;
    private Date date;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "patient_data_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
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
        private Integer id;


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

        public Builder withId(Integer id){
            this.id = id;
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
            if(this.id != null && this.id !=0) {
                response.setId(this.id);
            }
            return response;
        }
    }
}
