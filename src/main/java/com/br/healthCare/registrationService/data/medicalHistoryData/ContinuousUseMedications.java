package com.br.healthCare.registrationService.data.medicalHistoryData;

import com.br.healthCare.registrationService.data.MedicalHistory;

import javax.persistence.*;

@Entity
public class ContinuousUseMedications {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String medicationName;
    private String useTime;
    private String usageFrequency;
    private Double medicationDoseMg;
    @OneToOne
    @JoinColumn(name = "medicalHistory_id", foreignKey = @ForeignKey(name = "id"))
    private MedicalHistory medicalHistoryId;

    public Integer getId() {
        return id;
    }

    public ContinuousUseMedications setId(Integer id) {
        this.id = id;
        return this;
    }

    public int getMedicalHistoryId() {
        return medicalHistoryId.getId();
    }

    public ContinuousUseMedications setMedicalHistoryId(MedicalHistory medicalHistoryId) {
        this.medicalHistoryId = medicalHistoryId;
        return this;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public ContinuousUseMedications setMedicationName(String medicationName) {
        this.medicationName = medicationName;
        return this;
    }

    public String getUseTime() {
        return useTime;
    }

    public ContinuousUseMedications setUseTime(String useTime) {
        this.useTime = useTime;
        return this;
    }

    public String getUsageFrequency() {
        return usageFrequency;
    }

    public ContinuousUseMedications setUsageFrequency(String usageFrequency) {
        this.usageFrequency = usageFrequency;
        return this;
    }

    public Double getMedicationDoseMg() {
        return medicationDoseMg;
    }

    public ContinuousUseMedications setMedicationDoseMg(Double medicationDoseMg) {
        this.medicationDoseMg = medicationDoseMg;
        return this;
    }
}
