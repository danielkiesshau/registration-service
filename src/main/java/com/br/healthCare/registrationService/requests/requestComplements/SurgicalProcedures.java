package com.br.healthCare.registrationService.requests.requestComplements;

import java.util.Date;

public class SurgicalProcedures {

    private String procedureName;
    private String complications;
    private Date date;

    public String getProcedureName() {
        return procedureName;
    }

    private void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    public String getComplications() {
        return complications;
    }

    private void setComplications(String complications) {
        this.complications = complications;
    }

    public Date getDate() {
        return date;
    }

    private void setDate(Date date) {
        this.date = date;
    }

    public  static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private String procedureName;
        private String complications;
        private Date date;

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

        public SurgicalProcedures build(){
            SurgicalProcedures response = new SurgicalProcedures();
            response.setProcedureName(this.procedureName);
            response.setComplications(this.complications);
            response.setDate(this.date);

            return response;
        }
    }
}
