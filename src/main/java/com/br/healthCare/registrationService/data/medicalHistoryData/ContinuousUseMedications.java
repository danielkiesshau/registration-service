package com.br.healthCare.registrationService.data.medicalHistoryData;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ContinuousUseMedications {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String medicationName;
    private String useTime;
    private String usageFrequency;
    private Double medicationDoseMg;

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
