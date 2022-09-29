package com.br.healthCare.registrationService.data.medicalHistoryData;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class SurgicalProcedures {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String procedureName;
    private String complications;
    private Date date;

    public String getProcedureName() {
        return procedureName;
    }

    public SurgicalProcedures setProcedureName(String procedureName) {
        this.procedureName = procedureName;
        return this;
    }

    public String getComplications() {
        return complications;
    }

    public SurgicalProcedures setComplications(String complications) {
        this.complications = complications;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public SurgicalProcedures setDate(Date date) {
        this.date = date;
        return this;
    }
}
