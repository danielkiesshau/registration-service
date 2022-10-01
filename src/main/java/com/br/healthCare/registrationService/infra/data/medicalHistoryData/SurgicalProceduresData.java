package com.br.healthCare.registrationService.infra.data.medicalHistoryData;

import javax.persistence.*;
import java.util.Date;

@Entity
public class SurgicalProceduresData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String procedureName;
    private String complications;
    private Date date;


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
}
