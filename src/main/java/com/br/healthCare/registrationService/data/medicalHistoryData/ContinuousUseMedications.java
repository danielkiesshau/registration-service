package com.br.healthCare.registrationService.data.medicalHistoryData;

public class ContinuousUseMedications {
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
