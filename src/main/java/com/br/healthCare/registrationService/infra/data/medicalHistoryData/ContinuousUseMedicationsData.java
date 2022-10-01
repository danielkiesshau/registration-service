package com.br.healthCare.registrationService.infra.data.medicalHistoryData;

import javax.persistence.*;

@Entity
public class ContinuousUseMedicationsData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String medicationName;
    private String useTime;
    private String usageFrequency;
    private Double medicationDoseMg;


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
}
