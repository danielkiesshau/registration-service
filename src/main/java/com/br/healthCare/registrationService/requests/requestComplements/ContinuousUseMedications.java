package com.br.healthCare.registrationService.requests.requestComplements;

public class ContinuousUseMedications {
    private String medicationName;
    private String useTime;
    private String usageFrequency;
    private Double medicationDoseMg;

    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public String getUseTime() {
        return useTime;
    }

    public void setUseTime(String useTime) {
        this.useTime = useTime;
    }

    public String getUsageFrequency() {
        return usageFrequency;
    }

    public void setUsageFrequency(String usageFrequency) {
        this.usageFrequency = usageFrequency;
    }

    public Double getMedicationDoseMg() {
        return medicationDoseMg;
    }

    public void setMedicationDoseMg(Double medicationDoseMg) {
        this.medicationDoseMg = medicationDoseMg;
    }
}
