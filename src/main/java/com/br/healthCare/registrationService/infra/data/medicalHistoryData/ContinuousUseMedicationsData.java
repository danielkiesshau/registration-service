package com.br.healthCare.registrationService.infra.data.medicalHistoryData;

import com.br.healthCare.registrationService.infra.data.PatientData;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class ContinuousUseMedicationsData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    private String medicationName;
    private String useTime;
    private String usageFrequency;
    private Double medicationDoseMg;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "patient_data_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private PatientData patient;


    public Integer getId() {
        return id;
    }

    public ContinuousUseMedicationsData setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public ContinuousUseMedicationsData setMedicationName(String medicationName) {
        this.medicationName = medicationName;
        return this;
    }

    public String getUseTime() {
        return useTime;
    }

    public ContinuousUseMedicationsData setUseTime(String useTime) {
        this.useTime = useTime;
        return this;
    }

    public String getUsageFrequency() {
        return usageFrequency;
    }

    public ContinuousUseMedicationsData setUsageFrequency(String usageFrequency) {
        this.usageFrequency = usageFrequency;
        return this;
    }

    public Double getMedicationDoseMg() {
        return medicationDoseMg;
    }

    public ContinuousUseMedicationsData setMedicationDoseMg(Double medicationDoseMg) {
        this.medicationDoseMg = medicationDoseMg;
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
        private String medicationName;
        private String useTime;
        private String usageFrequency;
        private Double medicationDoseMg;
        public Integer patientId;
        private Integer id;

        public Builder withMedicationName(String medicationName){
            this.medicationName = medicationName;
            return this;
        }

        public Builder withUseTime(String useTime){
            this.useTime = useTime;
            return this;
        }

        public Builder withUSageFrequency(String usageFrequency){
            this.usageFrequency = usageFrequency;
            return this;
        }

        public Builder withMedicationDoseMg(Double medicationDoseMg){
            this.medicationDoseMg = medicationDoseMg;
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

        public ContinuousUseMedicationsData build(){
            ContinuousUseMedicationsData response = new ContinuousUseMedicationsData();
            response.setMedicationName(this.medicationName);
            response.setMedicationDoseMg(this.medicationDoseMg);
            response.setUseTime(this.useTime);
            response.setUsageFrequency(this.usageFrequency);
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
