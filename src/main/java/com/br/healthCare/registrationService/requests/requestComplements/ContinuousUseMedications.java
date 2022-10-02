package com.br.healthCare.registrationService.requests.requestComplements;

public class ContinuousUseMedications {
    private String medicationName;
    private String useTime;
    private String usageFrequency;
    private Double medicationDoseMg;

    public String getMedicationName() {
        return medicationName;
    }

    private void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public String getUseTime() {
        return useTime;
    }

    private void setUseTime(String useTime) {
        this.useTime = useTime;
    }

    public String getUsageFrequency() {
        return usageFrequency;
    }

    private void setUsageFrequency(String usageFrequency) {
        this.usageFrequency = usageFrequency;
    }

    public Double getMedicationDoseMg() {
        return medicationDoseMg;
    }

    private void setMedicationDoseMg(Double medicationDoseMg) {
        this.medicationDoseMg = medicationDoseMg;
    }

    public Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private String medicationName;
        private String useTime;
        private String usageFrequency;
        private Double medicationDoseMg;

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

            public ContinuousUseMedications build(){
            ContinuousUseMedications response = new ContinuousUseMedications();
            response.setMedicationName(this.medicationName);
            response.setMedicationDoseMg(this.medicationDoseMg);
            response.setUseTime(this.useTime);
            response.setUsageFrequency(this.usageFrequency);

            return response;
        }
    }
}
